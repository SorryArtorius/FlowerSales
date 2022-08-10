package servlet;

import com.alibaba.fastjson.JSONObject;
import com.j16.pojo.Detail;
import com.j16.service.impl.DetailServiceImpl;
import com.j16.service.impl.TypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


@WebServlet("/flowerSalesServlet")
public class FlowerSalesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tag = "";
        if (req.getParameter("tag")!=null){
            tag= req.getParameter("tag");
        }


        if ("showFlowers".equals(tag)){
            showFlowers(resp);
        }else if ("searchForFlowers".equals(tag)) {
            /**
             * 根据分类显示对于的花
             */
            int typeId = Integer.parseInt(req.getParameter("typeId"));
            if (typeId==0){
                showFlowers(resp);
            }else {
                List<Detail> detail = new DetailServiceImpl().getFlowers(typeId);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("detail",detail);
                resp.getWriter().write(jsonObject.toJSONString());
            }

        }else if ("sendAddFloweInformation".equals(tag)) {
            resp.sendRedirect("floralAddition.html");
        }else  if ("addFloweInformation".equals(tag)){
            /**
             * 获取花种类型
             */
            List<Type> type = new TypeServiceImpl().getTypeList();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("type",type);
            resp.getWriter().write(jsonObject.toJSONString());
        }
    }

    /**
     * 显示所有鲜花
     */
    private static void showFlowers(HttpServletResponse resp) throws IOException {
        /**
         * 返回花的信息
         */
        List<Detail> detail = new DetailServiceImpl().showFlowers();
        /**
         * 返回花种类信息
         */
        List<Type> type = new TypeServiceImpl().getTypeList();
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("detail",detail);
        jsonObject.put("type",type);
        resp.getWriter().write(jsonObject.toJSONString());
        System.out.println(jsonObject.toJSONString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tag = "";
        if (req.getParameter("tag")!=null){
            tag= req.getParameter("tag");
        }


        if ("addFloweInformation".equals(tag)){

            Detail detail = new Detail();
            int tid = Integer.parseInt(req.getParameter("flowers"));
            String flowerName = req.getParameter("flowerName");
            String manager = req.getParameter("manager");
            Double sellingPrice = Double.valueOf(req.getParameter("sellingPrice"));
            String purchaseDate = req.getParameter("purchaseDate");


            detail.setName(flowerName);
            detail.setManager(manager);
            detail.setPrice(sellingPrice);
            detail.setInstore(purchaseDate);
            detail.setTid(tid);
            if (new DetailServiceImpl().addDetail(detail)>0) {
                resp.sendRedirect("index.html");
            }else {
                resp.sendRedirect("floralAddition.html");
            }


        }

    }
}
