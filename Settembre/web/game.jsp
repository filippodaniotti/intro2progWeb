<%-- 
    Document   : game
    Created on : Feb 15, 2021, 11:23:23 AM
    Author     : Filippo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="js/frontend.js"></script>
        <title>Game</title>
    </head>
    <body>
        <h1 style="text-align: center">Giuoco</h1>
        <div class="container">
            <div class="row">
                <div class="col-sm-6" id="image"></div>
                <div class="col-sm-6">
                    <table id="words" class="table">
                        <tr>
                            <th>
                                <p>Word list</p>
                            </th>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-sm-6">
                    <div id="sender">
                        <input type="text" class=""form-control id="textbar">
                        <button class="btn btn-outline-dark btn-sm" onclick="addWord()">Send</button>
                    </div>
                </div>
            </div>
       </div>
        
      <script>
          loadImage($.urlParam('pic'));
          setTimeout(checkWin, 2000);
          if (window.closed) {
              console.log('unbinding');
              unbind();
          }
      </script>
      
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    </body>
</html>
