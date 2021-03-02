package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.AdoptionInfo
import com.example.androiddevchallenge.data.Gender
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.data.User
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainViewModel : ViewModel() {
    var startNow by mutableStateOf(false)
    var selectedFilter by mutableStateOf(0)

    val use1 = User("James Harden","335698","James@tt.com")
    val use2 = User("Micheal Jordan","2136547","Micheal@tt.com")
    val use3 = User("Kevin Durant","775623","Kevin@tt.com")

    val story1 = "Quis integre ad sea. At cum vidit equidem convenire. Simul partiendo eos id, sit aliquam expetenda ad. Petentium reprehendunt et mea, quo fierent sententiae dissentias ut, apeirian voluptatum vim eu. Mutat libris erroribus ius ei."
    val story2  = "Atqui inani pertinacia in sea, ferri falli commune at quo, graecis facilisi repudiare vix no. Et cum sumo clita insolens. Nobis impetus principes quo ut, nominati omittantur id nam."
    val story3 = "Has rebum delicata similique no. Illum erant accusata ei nam, eum pertinax sententiae interesset ei, cum modus aliquam ne."
    val story4 = " Pri at latine sanctus admodum, cum ut option delenit epicurei, mea ad vide deserunt. Tempor sententiae te duo, no praesent mediocrem facilisis duo. Ex est omnes laboramus comprehensam."
    val story5 = "Usu ex sonet nonumes nominavi, graeci dictas accusam usu ex, te vis prima cotidieque. Cibo mediocrem cu usu, eos probo singulis ad. Accumsan necessitatibus his ea, ad quo suas natum contentiones."


    var adoptionList  = listOf(
            AdoptionInfo(
                Puppy("Sky", Gender.Boy, "3~4 month", 1200, story1,
                story1,"Alaska","Great Pyrenees",R.drawable.puppy_1),
                condition = story2,
                location = "Alaska",
                contact = use1,
            ),
            AdoptionInfo(
                Puppy("Desk", Gender.Girl, "5~6 month", 1200, story1,
                    story2,"Annapolis","Alaskan Malamute",R.drawable.puppy_2),
                condition = story4,
                location = "Annapolis",
                contact = use2
            ),AdoptionInfo(
                Puppy("Mobil", Gender.Boy, "13~14 month", 1200, story1,
                    story5,"Alaska","Husky",R.drawable.puppy_3),
                condition = story2,
                location = "Alaska",
                contact = use3
            ),AdoptionInfo(
                Puppy("Jet", Gender.Girl, "8~9 month", 1200, story1,
                    story1,"Carson City","Poodle",R.drawable.puppy_4),
                condition = story5,
                location = "Carson City",
                contact = use2
            ),AdoptionInfo(
                Puppy("Himalaya", Gender.Girl, "10 month", 1200, story1,
                    story1,"Alaska","Border Collie",R.drawable.puppy_5),
                condition = story5,
                location = "Bismarck",
                contact = use1
            ),AdoptionInfo(
                Puppy("Sea", Gender.Boy, "19 month", 1200, story1,
                    story1,"Cheyenne","Papillon",R.drawable.puppy_6),
                condition = story4,
                location = "Cheyenne",
                contact = use1
            ),AdoptionInfo(
                Puppy("River", Gender.Boy, "3~4 month", 1200, story4,
                    story1,"Boston","Samoyed",R.drawable.puppy_7),
                condition = story3,
                location = "Boston",
                contact = use3
            )

    )

    var currentAdoptionList by mutableStateOf(adoptionList)

    fun filterPuppyList(index:Int){
        selectedFilter = index
        currentAdoptionList = when (index) {
            1 -> {
                adoptionList.filter {
                    it.puppy.gender == Gender.Boy
                }
            }
            2 -> {
                adoptionList.filter {
                    it.puppy.gender == Gender.Girl
                }
            }
            else ->
                adoptionList
        }
    }

    var selectedAdoption:AdoptionInfo? by mutableStateOf(null)

    var theme by mutableStateOf(MyTheme.Theme.Light)

    fun showAdoptionDetail(adoptionInfo: AdoptionInfo){
        selectedAdoption = adoptionInfo
    }

    fun dismissAdoptionDetail(){
        selectedAdoption = null
    }
}