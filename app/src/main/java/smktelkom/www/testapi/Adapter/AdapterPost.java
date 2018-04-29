package smktelkom.www.testapi.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import smktelkom.www.testapi.CommentActivity;
import smktelkom.www.testapi.Model.ModelPost;
import smktelkom.www.testapi.R;

/**
 * Created by M12RjUL14n on 29/04/2018.
 */

public class AdapterPost extends RecyclerView.Adapter<AdapterPost.ViewHolder> {
    List<ModelPost> postList;

    public AdapterPost(List<ModelPost> post) {
        postList = post;
    }

    @Override
    public AdapterPost.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_post, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterPost.ViewHolder holder, int position) {
        ModelPost post = postList.get(position);
        holder.title.setText(post.getTitle());
        holder.body.setText(post.getBody());
        final int id = post.getId();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), CommentActivity.class);
                i.putExtra("id", id);
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView body;

        public ViewHolder(final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}
