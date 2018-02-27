package cn.edu.computer.classcheckin;

import android.Manifest;
import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.computer.classcheckin.constant.Params;
import cn.edu.computer.classcheckin.constant.UrlPath;
import cn.edu.computer.classcheckin.entity.dto.CourseScheduleDTO;
import cn.edu.computer.classcheckin.entity.response.ClassScheduleResponse;
import cn.edu.computer.classcheckin.group.GroupItemDecoration;
import cn.edu.computer.classcheckin.group.GroupRecyclerView;
import cn.edu.computer.classcheckin.service.OkHttpService;
import cn.edu.computer.classcheckin.utils.LocationUtils;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        CalendarView.OnDateSelectedListener,
        CalendarView.OnYearChangeListener,
        View.OnClickListener{

    private FusedLocationProviderClient mFusedLocationClient;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static final int UPDATE_COURSE = 0x111;

    private Location mLastLocation;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case UPDATE_COURSE:
                    updateCourse((ClassScheduleResponse) msg.obj);
            }
        }
    };


    TextView mTextMonthDay;
    TextView mTextYear;
    TextView mTextLunar;
    TextView mTextCurrentDay;
    CalendarView mCalendarView;
    RelativeLayout mRelativeTool;
    private int mYear;
    CalendarLayout mCalendarLayout;
    GroupRecyclerView mRecyclerView;
    private static GoogleApiClient mGoogleApiClient;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @SuppressLint("MissingPermission")
    @Override
    protected void initView() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setStatusBarDarkMode();
        mTextMonthDay = findViewById(R.id.tv_month_day);
        mTextYear = findViewById(R.id.tv_year);
        mTextLunar = findViewById(R.id.tv_lunar);
        mRelativeTool = findViewById(R.id.rl_tool);
        mCalendarView = findViewById(R.id.calendarView);
        mTextCurrentDay = findViewById(R.id.tv_current_day);
        mTextMonthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mCalendarLayout.isExpand()) {
                    mCalendarView.showYearSelectLayout(mYear);
                    return;
                }
                mCalendarView.showYearSelectLayout(mYear);
                mTextLunar.setVisibility(View.GONE);
                mTextYear.setVisibility(View.GONE);
                mTextMonthDay.setText(String.valueOf(mYear));
            }
        });
        findViewById(R.id.fl_current).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendarView.scrollToCurrent();
            }
        });

        mCalendarLayout = findViewById(R.id.calendarLayout);
        mCalendarView.setOnDateSelectedListener(this);
        mCalendarView.setOnYearChangeListener(this);
        mTextYear.setText(String.valueOf(mCalendarView.getCurYear()));
        mYear = mCalendarView.getCurYear();
        mTextMonthDay.setText(mCalendarView.getCurMonth() + "月" + mCalendarView.getCurDay() + "日");
        mTextLunar.setText("今日");
        mTextCurrentDay.setText(String.valueOf(mCalendarView.getCurDay()));
    }

    @SuppressWarnings("MissingPermission")
    private void getLastLocation() {
        LocationUtils.initLocation(this);
        System.out.println(LocationUtils.longitude);

    }

    @Override
    protected void initData() {
        List<Calendar> schemes = new ArrayList<>();
        int year = mCalendarView.getCurYear();
        int month = mCalendarView.getCurMonth();

        schemes.add(getSchemeCalendar(year, month, 3, 0xFF40db25,"假"));
        schemes.add(getSchemeCalendar(year, month, 6, 0xFFe69138,"事"));
        schemes.add(getSchemeCalendar(year, month, 9, 0xFFdf1356,"议"));
        schemes.add(getSchemeCalendar(year, month, 13, 0xFFedc56d,"记"));
        schemes.add(getSchemeCalendar(year, month, 14, 0xFFedc56d,"记"));
        schemes.add(getSchemeCalendar(year, month, 15, 0xFFaacc44,"假"));
        schemes.add(getSchemeCalendar(year, month, 18, 0xFFbc13f0,"记"));
        schemes.add(getSchemeCalendar(year, month, 25, 0xFF13acf0,"假"));
        schemes.add(getSchemeCalendar(year, month, 27, 0xFF13acf0,"多"));
        mCalendarView.setSchemeDate(schemes);
        mCalendarView.setOnFocusChangeListener(new View.OnFocusChangeListener(){

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                System.out.println("Focus Calendar");
            }
        });
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new GroupItemDecoration<String,CourseScheduleDTO>());
        mRecyclerView.setAdapter(new CourseAdapter(this, new ArrayList<CourseScheduleDTO>()));
        mRecyclerView.notifyDataSetChanged();
    }

    private Calendar getSchemeCalendar(int year, int month, int day, int color,String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        calendar.addScheme(new Calendar.Scheme());
        calendar.addScheme(0xFF008800,"假");
        calendar.addScheme(0xFF008800,"节");
        return calendar;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDateSelected(Calendar calendar, boolean isClick) {
        try{
            String parma = String.format(Params.GET_CLASS_SCHEDULE, "0913072060"
                    , String.format("%d-%d-%d", calendar.getYear(), calendar.getMonth(), calendar.getDay()));
            Object[] taskParam = new String[]{UrlPath.GET_CLASS_SCHEDULE+parma};
            OkHttpService okHttpService = new OkHttpService(ClassScheduleResponse.class, handler, UPDATE_COURSE);
            okHttpService.execute(taskParam).get();
            mRecyclerView.notifyDataSetChanged();
            getLastLocation();
        }catch (Exception ex){
            Log.e(LOG_TAG,"getCourseSchedule", ex);
        }
    }

    @Override
    public void onYearChange(int year) {

    }

    private void updateCourse(ClassScheduleResponse response){
        if(response == null){
            return;
        }
        mRecyclerView.setAdapter(new CourseAdapter(this, response.getCourses()));
        mRecyclerView.notifyDataSetChanged();
    }
}
