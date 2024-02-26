package web_project.seveltjsp.jsp_PRJ.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web_project.seveltjsp.jsp_PRJ.controller.Controller;
import web_project.seveltjsp.jsp_PRJ.controller.ModelView;
import web_project.seveltjsp.jsp_PRJ.controller.ViewForwarder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/post/*")
public class PostFrontController extends HttpServlet {
    private Map<String, Controller> mappingController = new HashMap<>();

    public PostFrontController() {
        initMapping();

    }

    private void initMapping() {
        mappingController.put("/post/add", new PostAddController());
        mappingController.put("/post/add-form", new PostAddFormController());
        mappingController.put("/post/list", new PostListController());
        mappingController.put("/post/detail", new PostDetailController());
        mappingController.put("/post/delete", new PostDeleteController());
        mappingController.put("/post/my-list", new PostMyListController());
        mappingController.put("/post/update-form", new PostUpdateFormController());
        mappingController.put("/post/update", new PostUpdateController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        Controller controller = mappingController.get(requestURI);

        ModelView mv = controller.service(request, response);
        ViewForwarder viewForwarder = viewResolver(mv.getViewName());
        viewForwarder.render(request, response);
    }
    public ViewForwarder viewResolver(String viewName) {
        return new ViewForwarder("/WEB-INF/post/" + viewName + ".jsp");
    }
}
