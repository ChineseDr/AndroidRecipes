1.Volley的get和post请求方式的使用
    封装
    请求对象：
        StringRequest：请求返回结果类型不确定
        JsonObjectRequest：返回结果是JsonObject类型
        JsonArrayRequest：返回结果类型JsonArray
    回掉的使用

2。Volley的网络请求队列建立和取消队列请求
    建立一个全局的求情队列，在建立一个请求，然后把请求加入到全局队列中

3。Volley与Activity生命周期的联动
    在activity销毁时，关闭请求
    把此二者关联关键点在与需要设置Tag标签，通过Tag标签在队列中寻找请求，并在onStop方法中执行取消请求的操作

4。Volley的简单的二次回调封装
    全局的回调