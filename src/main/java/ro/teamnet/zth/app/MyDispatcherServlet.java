package ro.teamnet.zth.app;

import com.sun.java.util.jar.pack.*;
import com.sun.org.apache.xpath.internal.SourceTree;
import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.app.controller.DepartmentController;
import ro.teamnet.zth.app.controller.EmployeeController;
import ro.teamnet.zth.app.controller.JobsController;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by MN on 5/6/2015.
 */
public class MyDispatcherServlet extends HttpServlet {
    Map<String, MethodAttributes> allowedMethods = new HashMap<String, MethodAttributes>();

    private void dispatchReply(String method, HttpServletRequest req, HttpServletResponse resp) {

        try {
            Object r = dispatch(req, resp);
            reply(r, req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DispatchException de) {
            try {
                sendException(de, resp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void sendException(DispatchException de, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.printf("Nu s-a mapat url");

    }


    private Object dispatch(HttpServletRequest req, HttpServletResponse resp) {
        String path = req.getPathInfo();
        if (path.startsWith("/employees")) {
            if (path.startsWith("/employees/one")) {
                EmployeeController ec = new EmployeeController();
                return ec.getOneEmployee();

            } else


            {
                EmployeeController employeeController = new EmployeeController();
                String allEmployees = employeeController.getAllEmployees();
                return allEmployees;
            }
        }
        if (path.startsWith("/departments")) {
            DepartmentController dc = new DepartmentController();
            String allDepartments = dc.getAllDepartments();
            return allDepartments;
        }
        if (path.startsWith("/jobs")) {
            JobsController dc = new JobsController();
            String allJobs = dc.getAllJobs();
            return allJobs;
        }

        throw new DispatchException();


    }

    private void reply(Object r, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.printf(r.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          /*Delegate to someone (an application controller) */
        dispatchReply("GET", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /*Delegate to someone (an application controller) */
        dispatchReply("POST", req, resp);
    }

    @Override
    public void init() throws ServletException {
        try {
            Iterable<Class> classes = AnnotationScanUtils.getClasses("ro.teamnet.zth.app.controller");

            allowedMethods = getAllowedMethods(classes);
            System.out.println(allowedMethods);




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, MethodAttributes> getAllowedMethods(Iterable<Class> classes) {
        for (Class controller : classes) {
            if (controller.isAnnotationPresent(MyController.class)) {
                MyController myCtrlAn = (MyController) controller.getAnnotation(MyController.class);
                String controllerUrlPath = myCtrlAn.urlPath();
                Method[] controllerMethods = controller.getMethods();
                for (Method controllerMethod : controllerMethods) {
                    if (controllerMethod.isAnnotationPresent(MyRequestMethod.class)) {
                        MyRequestMethod myRqAn = (MyRequestMethod) controllerMethod.getAnnotation(MyRequestMethod.class);
                        String key = controllerUrlPath + myRqAn.urlPath();
                        MethodAttributes methodAttributes = new MethodAttributes();
                        methodAttributes.setControllerClass(controller.getName());
                        methodAttributes.setMethodName(controllerMethod.getName());
                        methodAttributes.setMethodType(myRqAn.methodType());
                        allowedMethods.put(key, methodAttributes);
                    }

                }


            }
        }
        return allowedMethods;
    }


}
