package sr.unasat.scheduleweb.controller;

import sr.unasat.scheduleweb.entities.Menu;
import sr.unasat.scheduleweb.service.MenuService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/menu")
public class MenuController {

    private MenuService menuService = new MenuService();
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Menu> findMenu(){
        System.out.println(menuService.findAll());
        return menuService.findAll();
    }
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void add(Menu menu){
        menuService.insertMenu(menu);
    }
    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(int menu){
        menuService.deleteMenu(menu);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMenu(Menu updatedMenu) {
        Menu menu = menuService.updateMenu(updatedMenu);
        if (menu == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(menu).build();
        }
    }

    @Path("/getMenu")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Menu getMenu(int menuId){
        return menuService.updateMenuInfo(menuId);
    }


}
