return：处理器方法的返回值表示请求的处理结果
1.ModelAndView：有数据和视图，对视图执行forward
2.String：表示视图，可以逻辑名称，也可以完整视图路径
3.void：不能表示数据，也不能表示视图。
在处理Ajax的时候，可以使用void返回值。通过HttpServletResponse输出数据。响应Ajax请求。Ajax请求服务器端返回的就是数据，和视图无关
4.Object：可以使用对象表示数据，响应Ajax请求

现在做Ajax，主要使用json的数据格式。实现步骤：
    1.加入处理json的工具库的依赖，SpringMVC默认使用Jackson
    2.在SpringMVC配置文件之间加入<mvc:annotation-driven>注解驱动
        json =om.writeValueAsString(student);
    3.在处理器方法的上面加入@ResponseBody注解
        response.setContentType("application/json;charset=utf-8");
                PrintWriter pw=response.getWriter();
                pw.println(json);

SpringMVC处理器方法返回Object，可以转为json输出到浏览器，响应Ajax的内部原理
1.<mvc:annotation-driven>注解驱动
    注解驱动实现的功能是完成Java对象到json，xml，text，二进制等数据格式的转换。
    HttpMessageConverter接口：消息转换器
    功能：定义了Java转为json，xml等数据格式的方法。这个接口有很多实现类。
        这些实现类完成Java对象到json，Java对象到xml，Java对象到二进制数据的转换

以下两个方法是控制器类把结果输出给浏览器时使用的：
    boolean canWrite(Class<?> var1, @Nullable MediaType var2);
    void write(T var1, @Nullable MediaType var2, HttpOutputMessage var3)

    1）CanWrite作用：检查处理器方法的返回值，能不能转为var2表示的数据格式
        MediaType：表示数据格式的
    2）write：调用Jackson中的ObjectMapper把处理器方法的返回值对象转为json字符串
        json =om.writeValueAsString(student);
2.@ResponseBody注解
    放在处理器方法的上面，通过HttpServletResponse输出数据，响应Ajax请求的
        response.setContentType("application/json;charset=utf-8");
                PrintWriter pw=response.getWriter();
                pw.println(json);