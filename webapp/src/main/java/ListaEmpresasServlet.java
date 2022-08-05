import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpresaDao dao = new EmpresaDao();
        List<Empresa> listaEmpresas = dao.retrieve();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for(Empresa empresa: listaEmpresas){
            out.println("<h1>Nome da Empresa "+empresa.getId()+ ": " +empresa.getNome()+"</h1>");
        }
        out.println("</body></html>");
    }
    
}
