package cn.edu.computer.classcheckin;

import android.app.ActionBar;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import cn.edu.computer.classcheckin.entity.dto.CourseScheduleDTO;
import cn.edu.computer.classcheckin.group.GroupRecyclerAdapter;

/**
 * 适配器
 * Created by panfei
 * on 2017/12/4.
 */

public class CourseAdapter extends GroupRecyclerAdapter<String, CourseScheduleDTO> {

    private RequestManager mLoader;

    public CourseAdapter(Context context, List<CourseScheduleDTO> courseScheduleDTOS) {
        super(context);

        mLoader = Glide.with(context.getApplicationContext());
        LinkedHashMap<String, List<CourseScheduleDTO>> map = new LinkedHashMap<>();
        List<String> titles = new ArrayList<>();
        if(courseScheduleDTOS != null && courseScheduleDTOS.size() > 0){
            map.put("今日课程", courseScheduleDTOS);
        }
        titles.add("今日课程");
        resetGroups(map,titles);
    }


    @Override
    protected RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type) {
        return new ArticleViewHolder(mInflater.inflate(R.layout.item_list_course, parent, false));
    }

    @Override
    protected void onBindViewHolder(RecyclerView.ViewHolder holder, CourseScheduleDTO courseSchedule, int position) {
        ArticleViewHolder h = (ArticleViewHolder) holder;
        h.mTextTitle.setText(courseSchedule.getCoursename());

        if(courseSchedule.getHasChecked()){
            h.mTextContent.setText("已经签到");
        }else{
            h.mTextContent.setText("尚未签到");
        }

        h.mTextTitle.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
    }

    private static class ArticleViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextTitle,
                mTextContent;
        private ImageView mImageView;

        private ArticleViewHolder(View itemView) {
            super(itemView);
            mTextTitle = itemView.findViewById(R.id.tv_title);
            mTextTitle.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
            mTextContent = itemView.findViewById(R.id.tv_content);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }
}
