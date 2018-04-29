package smktelkom.www.testapi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import smktelkom.www.testapi.Model.ModelComment;
import smktelkom.www.testapi.R;

/**
 * Created by M12RjUL14n on 29/04/2018.
 */

public class AdapterComment extends RecyclerView.Adapter<AdapterComment.ViewHolder> {
    List<ModelComment> CommentList;

    public AdapterComment(List<ModelComment> Comment) {
        CommentList = Comment;
    }

    @Override
    public AdapterComment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_comment, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterComment.ViewHolder holder, int position) {
        ModelComment comment = CommentList.get(position);
        holder.name.setText(comment.getName());
        holder.email.setText(comment.getEmail());
        holder.body.setText(comment.getBody());
    }

    @Override
    public int getItemCount() {
        return CommentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView email;
        TextView body;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            body = itemView.findViewById(R.id.body);
        }
    }
}
