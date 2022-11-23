package co.edu.uniquindio.proyecto.filtros;


import co.edu.uniquindio.proyecto.Bean.SeguridadBean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SeguridadFilter implements Filter {

    private final String PAGINA_INICIO = "/index.xhtml";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            final HttpServletRequest request = (HttpServletRequest) servletRequest;
            final HttpServletResponse response = (HttpServletResponse) servletResponse;
            final String requestURI = request.getRequestURI();
            //Aplicar el filtro a esta carpeta
            if (requestURI.startsWith("/usuario/")) {
                //Obtenemos el objeto seguridadBean de la sesión actual
                SeguridadBean userManager = (SeguridadBean) request.getSession().getAttribute("seguridadBean");
                if (userManager != null) {
                    if (userManager.isAutenticado()) {
                        //El usuario está logueado entonces si puede ver la páginasolicitada
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        //El usuario no está logueado, entonces se redirecciona al inicio
                        response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                    }
                } else {
                    //El usuario no está logueado, entonces se redirecciona al inicio
                    response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                }
            } else {
                if (requestURI.startsWith("/administrador/")) {
                    //Obtenemos el objeto seguridadBean de la sesión actual
                    SeguridadBean userManager = (SeguridadBean) request.getSession().getAttribute("seguridadBean");

                    if (userManager != null) {
                        if (userManager.isAutenticadoA()) {
                            //El usuario está logueado entonces si puede ver la página solicitada
                            filterChain.doFilter(servletRequest, servletResponse);
                        } else {
                            //El usuario no está logueado, entonces se redirecciona al inicio
                            response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                        }
                    } else {
                        //El usuario no está logueado, entonces se redirecciona al inicio
                        response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                    }
                } else {
                    //La página solicitada no está en la carpeta /usuario entonces el filtro no aplica
                    if (requestURI.startsWith("/administradorC/")) {
                        //Obtenemos el objeto seguridadBean de la sesión actual
                        SeguridadBean userManager = (SeguridadBean) request.getSession().getAttribute("seguridadBean");

                        if (userManager != null) {
                            if (userManager.isAutenticadoAC()) {
                                //El usuario está logueado entonces si puede ver la página solicitada
                                filterChain.doFilter(servletRequest, servletResponse);
                            } else {
                                //El usuario no está logueado, entonces se redirecciona al inicio
                                response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                            }
                        } else {
                            //El usuario no está logueado, entonces se redirecciona al inicio
                            response.sendRedirect(request.getContextPath() + PAGINA_INICIO);
                        }
                    } else {
                        //La página solicitada no está en la carpeta /usuario entonces el filtro no aplica
                        filterChain.doFilter(servletRequest, servletResponse);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
