package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class Fruit{
    private String name;
    private int imageId;
    public Fruit(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
    return name;
    }
    public int getImageId(){
        return imageId;
    }
}
class FruitAdapter extends ArrayAdapter<Fruit>{
     private int resourceId;
     public FruitAdapter(Context context, int textViewResourcedId, List<Fruit> objects){
         super(context,textViewResourcedId,objects);
         resourceId = textViewResourcedId;
     }
     public View getView(int position, View convertView, ViewGroup parent){
         Fruit fruit = getItem(position);//获取当前项的Fruit实例
         View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

         ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
         TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
         fruitImage.setImageResource(fruit.getImageId());
         fruitName.setText(fruit.getName());
         return view;
     }
}
public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    private String[]data = {
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();//初始化水果数据
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,android.R.layout.simple_list_item_1,data);*/
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
    private void initFruits(){
        for(int i=0;i<2;i++)
        {
            Fruit apple=new Fruit("apple",R.drawable.a);
            fruitList.add(apple);
            Fruit banana=new Fruit("banana",R.drawable.b);
            fruitList.add(banana);
            Fruit watermelon=new Fruit("watermelon",R.drawable.c);
            fruitList.add(watermelon);
            Fruit pear=new Fruit("pear",R.drawable.d);
            fruitList.add(pear);
            Fruit grape=new Fruit("grape",R.drawable.e);
            fruitList.add(grape);
            Fruit pineapple=new Fruit("pineapple",R.drawable.f);
            fruitList.add(pineapple);
            Fruit strawberry=new Fruit("strawberry",R.drawable.g);
            fruitList.add(strawberry);
            Fruit cherry=new Fruit("cherry",R.drawable.h);
            fruitList.add(cherry);
            Fruit mango=new Fruit("mango",R.drawable.i);
            fruitList.add(mango);

        }
    }
}
