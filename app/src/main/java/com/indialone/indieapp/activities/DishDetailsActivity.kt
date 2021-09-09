package com.indialone.indieapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.indialone.indieapp.R
import com.indialone.indieapp.databinding.ActivityDishDetailsBinding
import com.indialone.indieapp.utils.Constants
import com.indialone.indieapp.viewmodels.DishesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class DishDetailsActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityDishDetailsBinding
    private var dishId: String = ""

    @Inject
    lateinit var mDishesViewModel: DishesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityDishDetailsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setUpActionBar()

        if (intent.hasExtra(Constants.EXTRA_DISH_ID)) {
            dishId = intent.getStringExtra(Constants.EXTRA_DISH_ID)!!
        }

        if (dishId.isNotEmpty()) {
            mDishesViewModel.fetchRecipesDetails(dishId)
            mDishesViewModel.getRecipeDetails().observe(this) { recipeDetails ->
                val recipe = recipeDetails.recipe
                mBinding.tvTitleToolbar.text = recipe!!.title
                mBinding.tvTitle.text = recipe.title
                mBinding.tvPublisher.text = recipe.publisher
                mBinding.tvSocialRank.text = recipe.social_rank

                var ingredientsString = ""

                for (ingredient in recipe.ingredients!!) {
                    ingredientsString = "$ingredientsString-> $ingredient \n"
                }

                mBinding.tvIngredients.text = ingredientsString
                Glide.with(this)
                    .load(recipe.image_url)
                    .centerCrop()
                    .into(mBinding.ivDish)
            }
        }
    }

    private fun setUpActionBar() {
        setSupportActionBar(mBinding.toolbarDishDetails)

        val actionBar = supportActionBar

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.icon_back)
        }

        mBinding.toolbarDishDetails.setNavigationOnClickListener { onBackPressed() }
    }

}