package com.duruochen.kotlin

import android.media.MediaPlayer
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.duruochen.kotlin.databinding.FragmentFirstBinding
import com.google.gson.Gson
import kotlinx.coroutines.*
import org.json.JSONObject
import kotlin.coroutines.startCoroutine

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)



            suspend {

            }
        }

        binding.test.setOnClickListener {

            val coroutineScope = CoroutineScope(Dispatchers.Main)

            var i : Int = 0
            var j : Int = 0
            coroutineScope.launch {


                Log.d("duruochen", "start")


                async(Dispatchers.IO) {
                    Log.d("duruochen","aaa")
                    Thread.sleep(4000)
                    i = 7
                    Log.d("duruochen","bbb")

                }

                Log.d("duruochen", "i + j:${i + j}")

                withContext(Dispatchers.IO) {
                    Log.d("duruochen", "i  ${Thread.currentThread()}")
                    Thread.sleep(3000)
                    i = 5

                }

                withContext(Dispatchers.IO) {
                    Log.d("duruochen", "j   ${Thread.currentThread()}")
                    Thread.sleep(5000)
                    j = 6
                }

                Log.d("duruochen", "i + j:${i + j}")
            }

//            coroutineScope.launch {
//                Log.d("duruochen", "j1   ${Thread.currentThread()}")
//                j = 3
////                funTest.startCoroutine{
////
////                }
//            }
//            Log.d("duruochen", "i + j1:${i + j}")
//
//
//
//
//            coroutineScope.launch {
//                Log.d("duruochen", "1:" + Thread.currentThread())
//                async(Dispatchers.IO) {
//                    delay(10000)
//                    Log.d("duruochen", "2:" + Thread.currentThread())
//                }
//
//
//            }
//            val job= coroutineScope.launch(context = Dispatchers.IO) {
//                Log.d("duruochen", "3:" + Thread.currentThread())
//                slowMethod()
//                Log.d("duruochen", "5:" + Thread.currentThread())
//            }
//            job.invokeOnCompletion {
//                Log.d("duruochen", "协程执行完成")
//            }
//
//
//            job.cancel()
//
//            coroutineScope.launch(Dispatchers.IO, block = funTest)
//
//            coroutineScope.launch(Dispatchers.IO) {
//                Log.d("duruochen", "测试join1")
//                job.join()
//                Log.d("duruochen", "测试join2")
//            }
//
//            //处理协程的异常
//            val handler = CoroutineExceptionHandler { coroutineContext, throwable ->  }
//
//            //协程失败，崩溃：当出现了未捕获的异常时
//            val coroutineScope1 = CoroutineScope(Dispatchers.IO + Job() + SupervisorJob() +  handler)
//
//
//            coroutineScope.launch(start = CoroutineStart.LAZY) {  }
        }

        val aa =  Test()
        val jankTime = mutableMapOf<Long, Boolean>()
        jankTime.put(System.currentTimeMillis() - 111, false)
        jankTime.put(System.currentTimeMillis() - 222, true)
        jankTime.put(System.currentTimeMillis() - 333, false)
        jankTime.put(System.currentTimeMillis() - 444, true)
        jankTime.put(System.currentTimeMillis() - 555, false)
        jankTime.put(System.currentTimeMillis() - 666, false)
        jankTime.put(System.currentTimeMillis() - 777, false)
        jankTime.put(System.currentTimeMillis() - 888, true)
        jankTime.put(System.currentTimeMillis() - 999, false)
        jankTime.put(System.currentTimeMillis() + 111, true)
        jankTime.put(System.currentTimeMillis() + 222, false)
        jankTime.put(System.currentTimeMillis() + 333, false)

        aa.jankTime = jankTime
        val gson = Gson()

        Log.d("duruochen", "json:" +  gson.toJson(aa))

        Log.d("duruochen", "equals:" + (TextUtils.equals("aaa", "aa")) +  (TextUtils.equals("aaa", "aaa")))
    }

    val funTest: suspend CoroutineScope.() -> Unit = {
        Log.d("duruochen", "funTest")


    }

    suspend fun slowMethod() {
        withContext(Dispatchers.IO) {
            Log.d("duruochen", "4:" + Thread.currentThread())
            Thread.sleep(3 * 1000)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}