package com.example.project15.helper;

import android.graphics.Canvas;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project15.R;
import com.example.project15.adapter.CustomAdapter;

public class RecyclerItemTouchHelper extends ItemTouchHelper.SimpleCallback {

    private final RecyclerItemTouchHelperListener recyclerItemTouchHelperListener;

    public RecyclerItemTouchHelper(int dragDirs, int swipeDirs, RecyclerItemTouchHelperListener recyclerItemTouchHelperListener) {
        super(dragDirs, swipeDirs);
        this.recyclerItemTouchHelperListener = recyclerItemTouchHelperListener;
    }

    @Override
    public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        final View foregroundView = ((CustomAdapter.CustomViewHolder) viewHolder).view.findViewById(R.id.view_foreground);

        getDefaultUIUtil().onDrawOver(c, recyclerView, foregroundView, dX / 3, dY, actionState, isCurrentlyActive);

    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        final View foregroundView = ((CustomAdapter.CustomViewHolder) viewHolder).view.findViewById(R.id.view_foreground);

        getDefaultUIUtil().clearView(foregroundView);

    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        final View foregroundView = ((CustomAdapter.CustomViewHolder) viewHolder).view.findViewById(R.id.view_foreground);

        getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX / 3, dY, actionState, isCurrentlyActive);

    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        if (viewHolder != null) {
            final View foregroundView = ((CustomAdapter.CustomViewHolder) viewHolder).view.findViewById(R.id.view_foreground);

            getDefaultUIUtil().onSelected(foregroundView);
        }
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        recyclerItemTouchHelperListener.onSwiped(viewHolder, direction, viewHolder.getAdapterPosition());
    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    public interface RecyclerItemTouchHelperListener {
        void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position);
    }
}
