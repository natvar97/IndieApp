package com.indialone.indieapp.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.indialone.indieapp.IndieApplication
import com.indialone.indieapp.R
import com.indialone.indieapp.adapters.CustomListItemAdapter
import com.indialone.indieapp.adapters.DishesRvAdapter
import com.indialone.indieapp.databinding.DialogCustomListBinding
import com.indialone.indieapp.databinding.FragmentDishesBinding
import com.indialone.indieapp.databinding.ItemCustomListLayoutBinding
import com.indialone.indieapp.dishes.models.search.RecipesItem
import com.indialone.indieapp.utils.Constants
import com.indialone.indieapp.viewmodels.DishesViewModel
import com.indialone.indieapp.viewmodels.ViewModelFactory

class DishesFragment : Fragment() {

    private lateinit var mBinding: FragmentDishesBinding
    private lateinit var mCustomListDialog: Dialog
    private val dishesViewModel: DishesViewModel by viewModels {
        ViewModelFactory((activity?.application as IndieApplication).repository)
    }
    private var selectionString: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDishesBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dishesViewModel.getRecipes().observe(viewLifecycleOwner) { searchResponse ->
            mBinding.rvDishes.layoutManager = LinearLayoutManager(requireActivity())
            mBinding.rvDishes.adapter =
                DishesRvAdapter(searchResponse.recipes as ArrayList<RecipesItem>)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_filter, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_filter -> {
                filterDishesList()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun filterDishesList() {
        mCustomListDialog = Dialog(requireActivity())

        val binding: DialogCustomListBinding = DialogCustomListBinding.inflate(layoutInflater)
        mCustomListDialog.setContentView(binding.root)
        binding.tvTitle.text = Constants.TITLE_DIALOG
        binding.rvList.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvList.adapter = CustomListItemAdapter(
            requireActivity(),
            this,
            getSearchOptions(),
            Constants.FILTER_SELECTION
        )
        mCustomListDialog.show()

    }

    fun filterSelection(selection: String) {
        mCustomListDialog.dismiss()

        mBinding.tvDescription.visibility = View.GONE
        mBinding.rvDishes.visibility = View.VISIBLE

        dishesViewModel.fetchRecipes(selection)
        dishesViewModel.getRecipes().observe(viewLifecycleOwner) { searchResponse ->
            mBinding.rvDishes.layoutManager = LinearLayoutManager(requireActivity())
            mBinding.rvDishes.adapter =
                DishesRvAdapter(searchResponse.recipes as ArrayList<RecipesItem>)
        }
        selectionString = selection
    }

    private fun getSearchOptions(): ArrayList<String> {
        return arrayListOf(
            "carrot",
            "broccoli",
            "asparagus",
            "cauliflower",
            "corn",
            "cucumber",
            "green pepper",
            "lettuce",
            "mushrooms",
            "onion",
            "potato",
            "pumpkin",
            "red pepper",
            "tomato",
            "beetroot",
            "brussel sprouts",
            "peas",
            "zucchini",
            "radish",
            "sweet potato",
            "artichoke",
            "leek",
            "cabbage",
            "celery",
            "chili",
            "garlic",
            "basil",
            "coriander",
            "parsley",
            "dill",
            "rosemary",
            "oregano",
            "cinnamon",
            "saffron",
            "green bean",
            "bean",
            "chickpea",
            "lentil",
            "apple",
            "apricot",
            "avocado",
            "banana",
            "blackberry",
            "blackcurrant",
            "blueberry",
            "boysenberry",
            "cherry",
            "coconut",
            "fig",
            "grape",
            "kiwifruit",
            "lemon",
            "lime",
            "lychee",
            "mandarin",
            "mango",
            "melon",
            "nectarine",
            "orange",
            "papaya",
            "passion fruit",
            "peach",
            "pear",
            "pineapple",
            "plum",
            "pomegranate",
            "quince",
            "raspberry",
            "strawberry",
            "watermelon",
            "salad",
            "pizza",
            "pasta",
            "popcorn",
            "lobster",
            "steak",
            "bbq",
            "pudding",
            "hamburger",
            "pie",
            "cake",
            "sausage",
            "tacos",
            "kebab",
            "poutine",
            "seafood",
            "chips",
            "fries",
            "masala",
            "paella",
            "som tam",
            "chicken",
            "toast",
            "marzipan",
            "tofu",
            "ketchup",
            "hummus",
            "chili",
            "maple syrup",
            "parma ham",
            "fajitas",
            "champ",
            "lasagna",
            "poke",
            "chocolate",
            "croissant",
            "arepas",
            "bunny chow",
            "pierogi",
            "donuts",
            "rendang",
            "sushi",
            "ice cream",
            "duck",
            "curry",
            "beef",
            "goat",
            "lamb",
            "turkey",
            "pork",
            "fish",
            "crab",
            "bacon",
            "ham",
            "pepperoni",
            "salami",
            "ribs"
        )
    }

}