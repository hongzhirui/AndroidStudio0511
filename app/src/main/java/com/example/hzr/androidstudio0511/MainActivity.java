package com.example.hzr.androidstudio0511;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> students = new ArrayList<>();
    ListView listView;
    MyListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.id_listview);
        listAdapter = new MyListAdapter();
        listView.setAdapter(listAdapter);

        students.add(new Student(201901, "刘同", true));
        students.add(new Student(201902, "张海", true));
        students.add(new Student(201903, "李梅", false));
        students.add(new Student(201904, "韩雷", true));
        students.add(new Student(201905, "李曼", false));
        students.add(new Student(201906, "张伟", true));
        students.add(new Student(201907, "张小娴", false));
        students.add(new Student(201908, "金成", true));
        students.add(new Student(201909, "张立", true));
        students.add(new Student(201910, "吴天", true));
        students.add(new Student(201911, "尧婷", false));
        students.add(new Student(201912, "邱芬", false));

        showAll();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onListItemClicked(position);
            }
        });
    }

    private void onListItemClicked(int position){
        Student data = (Student)listAdapter.getItem(position);
        Toast.makeText(this, "点中了："+data.name, Toast.LENGTH_SHORT).show();
    }

    private void showAll(){
        listAdapter.result.addAll(students);
        listAdapter.notifyDataSetChanged();
    }

    public class Student{
        public int number;
        public String name;
        public boolean sex;

        public Student(int number, String name, boolean sex){
            this.number = number;
            this.name = name;
            this.sex = sex;
        }
    }

    public class MyListAdapter extends BaseAdapter{
        ArrayList<Student> result = new ArrayList<>();

        public MyListAdapter(){

        }

        @Override
        public int getCount() {
            return result.size();
        }

        @Override
        public Object getItem(int position) {
            return result.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null)
                convertView=getLayoutInflater().inflate(R.layout.student_layout, parent, false);
            Student data = (Student)getItem(position);

            TextView textView1 = (TextView)convertView.findViewById(R.id.id_textView1);
            textView1.setText(data.name);

            TextView textView2 = (TextView)convertView.findViewById(R.id.id_textView2);
            textView1.setText(data.number);
            return convertView;
        }
    }
}
