### Adapter


### Adapter 패턴
Adapter 패턴이란 서로 호환될 수 없는 인터페이스들을 연결하여 유기적으로 작동할 수 있게해주는 패턴이다.

기본 WebServlet + JSP + MVC 패턴을 적용하여 만든 게시판 프로젝트를 어댑터 패턴을 적용하여 만들었다.

```java
public interface Controller {  
    ModelView service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;  
}

```
```java
public interface MyAdapter {  
    boolean supports(Object handler);  
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;  
}
```
```java
public class MyHandler implements MyAdapter {  
    @Override  
    public boolean supports(Object handler) {  
        return (handler instanceof Controller);  
    }  
  
    @Override  
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {  
        Controller controller = (Controller) handler;  
        return controller.service(request, response);  
    }  
}
```
```java
@WebServlet("/*")  
public class AdapterFrontController extends HttpServlet {  
    private final Map<String, Object> handlerMappingMap = new HashMap<>();  
    private final List<MyAdapter> adapterList = new ArrayList<>();  
  
    public AdapterFrontController() {  
        initMappingURI();  
        initAdapter();  
    }  
    private void initAdapter() {  
        adapterList.add(new MyHandler());  
    }  
    private void initMappingURI() {  
        handlerMappingMap.put("/post/add", new PostAddController());  
        handlerMappingMap.put("/post/add-form", new PostAddFormController());  
        handlerMappingMap.put("/post/list", new PostListController());  
        handlerMappingMap.put("/post/detail", new PostDetailController());  
        handlerMappingMap.put("/post/delete", new PostDeleteController());  
        handlerMappingMap.put("/post/my-list", new PostMyListController());  
        handlerMappingMap.put("/post/update-form", new PostUpdateFormController());  
        handlerMappingMap.put("/post/update", new PostUpdateController());  
  
        handlerMappingMap.put("/member/addForm", new MemberAddFormController());  
        handlerMappingMap.put("/member/add", new MemberAddController());  
        handlerMappingMap.put("/member/login", new MemberLoginController());  
        handlerMappingMap.put("/member/logout", new MemberLogoutController());  
    }  
    @Override  
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        String requestURI = request.getRequestURI();  
        Object handler = handlerMappingMap.get(requestURI);  
  
        MyAdapter adapter = adapter(handler);  
        ModelView mv = adapter.handle(request, response, handler);  
        ViewForwarder vf = viewResolver(mv.getViewName());  
        vf.render(request, response);  
  
    }  
    private ViewForwarder viewResolver(String viewName) {  
        return new ViewForwarder("/WEB-INF" + viewName + ".jsp");  
    }  
  
    private MyAdapter adapter(Object handler) {  
        for (MyAdapter myAdapter : adapterList) {  
            if (myAdapter.supports(handler)) {  
                return myAdapter;  
            }  
        }  
        throw new IllegalArgumentException("No found handler" + handler);  
    }  
}
```
