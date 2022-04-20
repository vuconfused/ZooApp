package com.example.zooapp

import android.os.BaseBundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    var listOfAnimal = ArrayList<Animal>()
    var adapter : AnimalsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load animals
        listOfAnimal.add(Animal("Baboon", "Baboon live in big place with tree", R.drawable.baboon))
        listOfAnimal.add(Animal("Bulldog", "Bulldog live in big place with tree", R.drawable.baboon))
        listOfAnimal.add(Animal("Panda", "Panda live in big place with tree", R.drawable.baboon))
        listOfAnimal.add(Animal("Swallow", "Swallow live in big place with tree", R.drawable.baboon))
        listOfAnimal.add(Animal("Tiger", "Tiger live in big place with tree", R.drawable.baboon))
        listOfAnimal.add(Animal("Zebra", "Zebra live in big place with tree", R.drawable.baboon))
        adapter = AnimalsAdapter(listOfAnimal)
    }

    class AnimalsAdapter: BaseAdapter{
        var listOfAnimal = ArrayList<Animal>()
        constructor(listOfAnimal: ArrayList<Animal>):super(){
            this.listOfAnimal = listOfAnimal
        }
        override fun getCount(): Int {
            return listOfAnimal.size
        }

        override fun getItem(p0: Int): Any {
            return listOfAnimal[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal = listOfAnimal[p0]
            var myView = layoutInflater.inflate(R.layout.animal_ticket,null)
            myView.tvName.text = animal.name
            myView.tvDes.text = animal.des
            myView.ivAnimalImage.setImageResource(animal.image)
        }

    }
}