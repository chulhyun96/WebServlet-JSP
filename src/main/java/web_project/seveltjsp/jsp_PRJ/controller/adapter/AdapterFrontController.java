package web_project.seveltjsp.jsp_PRJ.controller.adapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_project.seveltjsp.jsp_PRJ.controller.ModelView;
import web_project.seveltjsp.jsp_PRJ.controller.ViewForwarder;
import web_project.seveltjsp.jsp_PRJ.controller.member.add.MemberAddController;
import web_project.seveltjsp.jsp_PRJ.controller.member.add.MemberAddFormController;
import web_project.seveltjsp.jsp_PRJ.controller.member.login.MemberLoginController;
import web_project.seveltjsp.jsp_PRJ.controller.member.login.MemberLogoutController;
import web_project.seveltjsp.jsp_PRJ.controller.post.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
