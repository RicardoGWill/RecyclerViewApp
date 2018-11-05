package Adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ricardogwill.recyclerviewapp.DetailsActivity;
import com.ricardogwill.recyclerviewapp.R;

import java.util.List;

import Model.ListItem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<ListItem> listItems;

    public MyAdapter(Context context, List<ListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This inflates the "list_row.xml" view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        ListItem item = listItems.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    // New Class!  This sets all of the views (name, description).
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, description;
        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            name = (TextView) itemView.findViewById(R.id.titleTV);
            description = (TextView) itemView.findViewById(R.id.descriptionTV);
        }

        @Override
        public void onClick(View v) {
            // Get position of the row that is tapped.
            int positionInt = getAdapterPosition();

            ListItem item = listItems.get(positionInt);
            // Explicit Intent to go to "DetailsActivity".
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("name", item.getName());
            intent.putExtra("description", item.getDescription());
            // Needs to use "context".
            context.startActivity(intent);

            Toast.makeText(context, item.getName(), Toast.LENGTH_SHORT).show();

        }
    }
}
