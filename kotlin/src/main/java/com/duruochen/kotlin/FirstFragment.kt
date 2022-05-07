package com.duruochen.kotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.duruochen.kotlin.databinding.FragmentFirstBinding
import kotlinx.coroutines.*

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
        }

        binding.test.setOnClickListener {

            val coroutineScope = CoroutineScope(Dispatchers.Main)
            coroutineScope.launch {
                Log.d("duruochen", "1:" + Thread.currentThread())
                async(Dispatchers.IO) {
                    Log.d("duruochen", "2:" + Thread.currentThread())
                }
            }
            val job= coroutineScope.launch(context = Dispatchers.IO) {
                Log.d("duruochen", "3:" + Thread.currentThread())
                slowMethod()
                Log.d("duruochen", "5:" + Thread.currentThread())
            }
            job.invokeOnCompletion {
                Log.d("duruochen", "协程执行完成")
            }



            coroutineScope.launch(Dispatchers.IO, block = funTest)

            coroutineScope.launch(Dispatchers.IO) {
                Log.d("duruochen", "测试join1")
                job.join()
                Log.d("duruochen", "测试join2")
            }



            //处理协程的异常
            val handler = CoroutineExceptionHandler { coroutineContext, throwable ->  }

            //协程失败，崩溃：当出现了未捕获的异常时
            val coroutineScope1 = CoroutineScope(Dispatchers.IO + Job() + SupervisorJob() +  handler)

        }
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