//package com.example.newreciclerview
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.google.firebase.firestore.ktx.firestore
//import com.google.firebase.ktx.Firebase
//
//class UserViewModel: ViewModel() {
//
//    private var db = Firebase.firestore
//    private val users = "users"
//
//    val createLiveData: MutableLiveData<Boolean> by lazy {
//        MutableLiveData<Boolean>()
//    }
//
//    val updateLiveData: MutableLiveData<Boolean> by lazy {
//        MutableLiveData<Boolean>()
//    }
//
//    val getListLiveData: MutableLiveData<List<User>> by lazy {
//        MutableLiveData<List<User>>()
//    }
//
//    val deleteLiveData: MutableLiveData<Boolean> by lazy {
//        MutableLiveData<Boolean>()
//    }
//
//    fun create(product: User) {
//        val docRef = db.collection(users)
//        docRef.add(users.toMap()).addOnSuccessListener {
//            createLiveData.postValue(true)
//        }.addOnFailureListener {
//            Log.d("create", it.localizedMessage!!)
//            createLiveData.postValue(false)
//        }
//    }
//
//    fun update(product: User) {
//        val docRef = db.collection(users)
//        docRef.document(product.id!!).update(product.toMap()).addOnSuccessListener {
//            updateLiveData.postValue(true)
//        }.addOnFailureListener {
//            Log.d("update", it.localizedMessage!!)
//            updateLiveData.postValue(false)
//        }
//    }
//
//    fun delete(id: String) {
//        val docRef = db.collection(users)
//        docRef.document(id).delete().addOnSuccessListener {
//            deleteLiveData.postValue(true)
//        }.addOnFailureListener {
//            Log.d("delete", it.localizedMessage!!)
//            deleteLiveData.postValue(false)
//        }
//    }
//
//    fun getList() {
//        val docRef = db.collection(users)
//        docRef.get().addOnSuccessListener {
//            val products = ArrayList<User>()
//            for (item in it.documents) {
//                val product = User()
//                product.id = item.id
//                product.name = item.data!!["name"] as String?
//                product.price = item.data!!["price"] as Double?
//                product.description = item.data!!["description"] as String?
//                product.create_date = item.data!!["create_date"] as Timestamp?
//                product.update_date = item.data!!["update_date"] as Timestamp?
//                users.add(product)
//            }
//
//            getListLiveData.postValue(products)
//        }.addOnFailureListener {
//            Log.d("get", it.localizedMessage!!)
//            getListLiveData.postValue(null)
//        }
//    }
//}