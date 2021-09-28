<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
  
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
   
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css"
      integrity="sha256-mmgLkCYLUQbXn0B1SRqzHar6dCnv9oZFPEC1g1cwlkk="
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
      crossorigin="anonymous"
    />


    <title>Traveller</title>
  </head>
  <body>

    <section class="container">
      <div class="justify-content-center align-items-center row h-100">
        <div class="col-10 col-lg-4">
          <form class="loginservlet" method="post">
            <div class="text-center mb-2">
              <h2>Login</h2>
              <div class="form-group">
                <input
                  type="text"
                  placeholder="E-mail"
                  class="form-control"
                  name="txtLogin"
                />
              </div>
              <div class="form-group">
                <input
                  type="password"
                  placeholder="Senha"
                  class="form-control"
                  name="txtSenha"
                />
              </div>
              <a href=""><button class="btn btn-block btn-lg" name="enviardados"></a>
                Entrar
              </button>
            </div>
          </form>
        </div>
      </div>
    </section>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
