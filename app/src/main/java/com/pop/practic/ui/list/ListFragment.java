package com.pop.practic.ui.list;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pop.practic.R;
import com.pop.practic.app.App;
import com.pop.practic.databinding.FragmentListBinding;
import com.pop.practic.repository.Repository;
import com.pop.practic.repository.room.todolist.ToDoRef;
import com.pop.practic.repository.room.todolist.ToDoRefDAO;
import com.pop.practic.repository.room.todolist.ToDoRefDB;
import com.pop.practic.ui.list.adapters.NotesAdapter;
import com.pop.practic.ui.list.adapters.ToDoAdapter;

import java.util.List;

public class ListFragment extends Fragment {
    NotesAdapter notesAdapter = new NotesAdapter(App.getInstance().getRepository());
    ToDoAdapter toDoAdapter = new ToDoAdapter(App.getInstance().getRepository());
    FragmentListBinding fragmentListBinding;
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentListBinding = FragmentListBinding.inflate(inflater, container, false);
        fragmentListBinding.notesRecyclerView.setAdapter(notesAdapter);
        fragmentListBinding.todoRecyclerView.setAdapter(toDoAdapter);
        return fragmentListBinding.getRoot();
    }


}