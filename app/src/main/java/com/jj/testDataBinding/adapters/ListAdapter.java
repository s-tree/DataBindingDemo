package com.jj.testDataBinding.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jj.testDataBinding.R;
import com.jj.testDataBinding.data.User;
import com.jj.testDataBinding.databinding.ListItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {
    private List<User> userList = new ArrayList<>();
    private View.OnClickListener onClickListener;
    private ListAdapterDiffCallback diffCallback;

    public ListAdapter(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        diffCallback = new ListAdapterDiffCallback();
    }

    public void setData(List<User> tempListSize){
        if(tempListSize == null || tempListSize.isEmpty()){
            userList.clear();
            notifyDataSetChanged();
            return;
        }
        diffCallback.setData(userList,tempListSize);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(diffCallback);
        userList.clear();
        userList.addAll(tempListSize);
        result.dispatchUpdatesTo(this);
    }

    public void insertData(User user){
        this.userList.add(0,user);
        notifyItemInserted(0);
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
        User user = userList.get(i);
        listHolder.binding.setUser(user);
        listHolder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class ListHolder extends RecyclerView.ViewHolder{
        private ListItemBinding binding;

        ListHolder(@NonNull ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    static class ListAdapterDiffCallback extends DiffUtil.Callback {
        List<User> mOldData = new ArrayList<>();
        List<User> mNewData = new ArrayList<>();

        private void setData(List<User> oldData,List<User> newData){
            mOldData.clear();
            mOldData.addAll(oldData);
            mNewData.clear();
            mNewData.addAll(newData);
        }

        @Override
        public int getOldListSize() {
            return mOldData.size();
        }

        @Override
        public int getNewListSize() {
            return mNewData.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            User oldUser = mOldData.get(oldItemPosition);
            User newUser = mNewData.get(newItemPosition);
            return oldUser.id == newUser.id;
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            User oldUser = mOldData.get(oldItemPosition);
            User newUser = mNewData.get(newItemPosition);
            return oldUser.id == newUser.id
                    && TextUtils.equals(oldUser.getName(),newUser.getName());
        }
    }
}
