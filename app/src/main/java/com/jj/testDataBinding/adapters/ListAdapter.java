package com.jj.testDataBinding.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jj.testDataBinding.R;
import com.jj.testDataBinding.data.User;
import com.jj.testDataBinding.databinding.ListItemBinding;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {
    List<User> userList;
    View.OnClickListener onClickListener;

    public ListAdapter(List<User> userList,View.OnClickListener onClickListener) {
        this.userList = userList;
        this.onClickListener = onClickListener;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.list_item,viewGroup,false);
        binding.setOnClickListener(onClickListener);
        return new ListHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder listHolder, int i) {
        listHolder.binding.setUser(userList.get(i));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ListHolder extends RecyclerView.ViewHolder{
        private ListItemBinding binding;

        public ListHolder(@NonNull ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
