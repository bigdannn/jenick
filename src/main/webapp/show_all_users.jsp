<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>

    <head>
        <title>All Users</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>

    <body>

  <hr>
     <div class="row center-block text-center">
          <h1> List of All Users </h1>
     </div>

  <hr>

         <nav class="navbar navbar-light bg-light">
                  <div class="container-fluid">
                      <div class="col-4">
                            <form action="user" method = "get" class="d-flex">
                                <input type="hidden" name="command" value="get_user_by_family_name">
                                <div class="col-8">
                                   <input class="form-control me-2" type="text" placeholder="Enter family name" name="family_name">
                                </div>
                                <div class="col-4">
                                    <button class="btn btn-outline-secondary btn-md btn-block" type="submit">Search</button>
                                </div>
                            </form>
                      </div>
                      <div class="col-4">
                           <form action="user" method = "get" class="d-flex">
                                 <input type="hidden" name="command" value="get_all_users">
                                 <div class="col-4">
                                     <button class="btn btn-outline-secondary btn-md btn-block" type="submit">All users</button>
                                 </div>
                           </form>
                      </div>
                      <div class="col-4">
                                 <div class="col-4">
                                     <a href="show_user_details.jsp">
                                         <button class="btn btn-outline-dark btn-sm btn-block" type="submit">Create user</button>
                                    </a>
                                 </div>
                      </div>

                  </div>
         </nav>

<hr>


 <div class="row center-block text-center">
         <h4>${message}</h4>
     </div>

<hr>
       <table class="table table-striped table-hover">
        <thead class="table-light">
          <tr>
            <th class="text-center">ID</th>
            <th class="text-center">Given name</th>
            <th class="text-center">Family name</th>
            <th class="text-center">Age</th>
            <th></th>
            <th></th>
           </tr>
        </thead>

        <c:forEach var="item" items="${user_list}">
        <tr>
            <td class="text-center">${item.id}</td>
            <td class="text-center">${item.givenName}</td>
            <td class="text-center">${item.familyName}</td>
            <td class="text-center">${item.age}</td>
            <td>
                <form action="user" method="get">
                    <input type="hidden" name="command" value="get_user_by_id">
                    <input type="hidden" name="id" value=${item.id}>
                    <button class="btn btn-outline-dark btn-sm btn-block" type="submit">Update</button>
                 </form>
            </td>
            <td>
                <form action="user" method="post">
                     <input type="hidden" name="command" value="delete_user">
                     <input type="hidden" name="id" value=${item.id}>
                     <button class="btn btn-outline-dark btn-sm btn-block" type="submit">Delete</button>
                </form>
            </td>
        </tr>
        </c:forEach>
        </table>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>

<c:remove var = "message" />