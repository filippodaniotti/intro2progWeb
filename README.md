# Introduzione alla programmazione per il web

## Snippets per cose importanti

### Alcuni elementi già pronti

#### Header generico

```jsp
<% String username = (String) session.getAttribute("username");
    String logout = "";
    String login = "";
    String user = "";
    if (username != null) {
        user = "<span style=\"color:white\">" + username + "</span>";
        logout = "<a href=\"/2021_Giugno/Logout\" style=\"color:white; margin-left:2rem\">Logout</a>";
    } else {
        login = "<a href=\"/2021_Giugno/login.html\" style=\"color:white\">Login</a>";
    }
%>

<nav class="navbar navbar-dark bg-dark">
    <span style="color:white; margin-right: 10px">ASTE</span>
    <a href="/2021_Giugno/HomeController" style="color:white; margin-right: 5px">Aperte</a>
    <a href="/2021_Giugno/SoldController" style="color:white">Terminate</a>
    <span class="spacer"></span>
    <%= user %>
    <%= logout %>
    <%= login %>
</nav>
```

#### Form di login generico

```html
<body class="text-center">
  <form class="form-signin center" method="POST" action="/Giugno/createGame">
    <h1 class="h3 mb-3 font-weight-normal">Please enter your name</h1>
    <input
      type="text"
      class="form-control formInput"
      placeholder="Your username"
      name="username"
      required
      autofocus
    />
    <button class="btn btn-lg btn-primary btn-block" type="submit">
      Submit
    </button>
  </form>
</body>
```

#### Tabella con ternary operator

```jsp
<table>
  <%for (int i = 0; i < 9; ++i) {%>
	  <tr>
      <%for (int j = 0; j < 9; ++j) {%>
        <td><input
          type="text"
          id="<%=i+1%><%=j+1%>"
          class="<%= (Config.isRed(i, j) ? "rose" : "blue")%>"
          onchange="checkInput('<%=i%>', '<%=j%>')">
        </td>
      <%}%>
    </tr>
  <%}%>
</table>
```

#### Input field con bottone sulla destra
```jsp
<div class="input-group" id="wordField">
  <input class="form-control" id="word" placeholder="Type your word" autofocus>
  <span class="input-group-btn">
    <button class="btn btn-primary" type="button" onclick="sendWord('<%=key%>', '<%=user%>')">Go!</button>
  </span>
</div>
```

### Tricks per CSS

#### Base

```css
.spacer {
  flex: 1 1 auto;
}

.main-container {
  padding-top: 10px;
  padding-left: 30px;
  padding-right: 30px;
}

.center {
  margin: 0;
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);
}

#div1 {
  display: block;
  margin: auto;
  width: /*anything under*/ 100%;
}

.hidden {
  visibility: hidden;
}
```

#### Grid di due colonne

```css
.column {
  float: left;
  width: 50%;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
```

### The Javascript survival guide

#### Associare un evento alla pressione di enter per un input field

```js
$(document).ready(function () {
  let input = document.getElementById("message");
  input.addEventListener("keyup", function (event) {
    if (event.keyCode === 13) {
      event.preventDefault();
      $("#sendButton").click();
    }
  });
});
```

#### Recuperare un dato parametro dall'URL

```js
function getUrlParam(parameter, defaultvalue) {
  var urlparameter = defaultvalue;
  if (window.location.href.indexOf(parameter) > -1) {
    urlparameter = getUrlVars()[parameter];
  }
  return urlparameter;
}

function getUrlVars() {
  var vars = {};
  var parts = window.location.href.replace(
    /[?&]+([^=&]+)=([^&]*)/gi,
    function (m, key, value) {
      vars[key] = value;
    }
  );
  return vars;
}
```

#### Modificare l'URL corrente senza ricaricare

```js
window.history.replaceState({}, "", "Viewer");
```

#### Popolare struttura dati js con dati dinamici da jsp
```jsp
<script>
  <!-- var fixedCells = [];
	  var fixedCellsValues = {}; -->
  $(document).ready(function () {
    <%if (cells == null) {%>
      window.alert("Error in generated game, you will be redirected to home");
      setTimeout(function () {
        window.location.replace('/Febbraio');
        }, 2000);
    <%} else {%>
      <%for (String cell : cells) {%>
        fixedCells.push('<%=cell%>');
        <%if(fixed.get(cell) != null) {%>
          fixedCellsValues['<%=cell%>'] = '<%=fixed.get(cell)%>';
        <%}%>
      <%}%>
      initialize();
    <%}%>
    });
</script>
```

### Recuperare e salvare destinazione in un filtro

All'interno del filtro, se scopriamo che non esiste una sessione o che a questa non è associatoa lcun utente, possiamo attaccare alla richiesta la destinazione richiesta al server prima di reindirizzare con il `requestDispatcher`.

```java
String url = httpRequest.getServletPath();
String queryString = httpRequest.getQueryString();
if (queryString!=null) {
  url = url + "?" + queryString;
}
request.setAttribute("destination", url);
```

A questo punto, possiamo ripassare la destinazione in una jsp di login come elemento HTML `input` con attributo `hidden`.

```jsp
<input type="hidden" name="destination" value="<%=request.getAttribute("destination")%>">
```

A questo punto possiamo recuperare la destinazione originaria come un qualsiasi altro parametro nella nostra servlet di autenticazione e ivi reindirizzare la richiesta in caso l'autenticazione andasse a buon fine.

### Derby

La prima cosa da fare è pregare che Netbeans e Derby siano installati dritti. Appurato questo, è sufficiente:

- naviagare sulla tab _services_ di Netbeans
- espandere il campo _Database_
- right click on _JavaDB_
- creare un nuovo database con un nome, uno username e una password
- assicurarsi di avviare la connessione al database

Buono, adesso c'è il database. È possibile creare tabelle e inserire delle entries in maniera piuttosto comoda dall'editor di Netbeans, così come anche eseguire dei comandi SQL. Forse quest'ultimo approccio è più conveniente, perché così possiamo salvare i vari `CREATE TABLE YOLO` e `INSERT INTO BLABLABLA` in un file e poter ricreare il database agevolmente in caso qualcosa andasse storto.

Passiamo al codice. Conviene prepararsi fin da subito le credenziali di accesso al database:

```java
private String dbURL = "jdbc:derby://localhost:1527/<nomeDB>";
private String user = "<usernameDB>";
private String password = "<passwordDB>";
public Connection conn = null;
```

#### Connessione perServlet

Supponendo di voler effettuare una connessione _perServlet_, dobbiamo inizializzata nell'`init()` e chiusa nel `destroy()` della servlet. Prepariamoci quindi a fare l'override di questi metodi:

```java
@Override
public void init()
        throws ServletException {
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver"); // Get the driver
        conn = DriverManager.getConnection(dbURL, user, password); // Open connection
    } catch (ClassNotFoundException | SQLException ex) {
        ex.printStackTrace();
    }
}

@Override
public void destroy() {
    try {
        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
```

A questo punto possiamo senza problemi effettuare transazioni all'interno dei metodi che processano le richieste in ingresso:

- prepariamo un oggetto `Statement` utilizzando il metodo `createStatement()` della connessione
- utilizziamo il metodo `executeQuery(String query)` dello statement per eseguire una query, che sarà una stringa scritta nel linguaggio opportuno
- il ritorno di `executeQuery()` sarà un'istanza di un oggetto `ResultSet`

Pare sia opportuno eseguire le query all'interno di un blocco `try-catch`.

```java
// ...
// PrintWriter out = abbiamo un PrintWriter
try {
    Statement stmt = conn.createStatement();
    String query = "select * from SOME_TABLE"; // Non inserire ; nella query!
    ResultSet results = stmt.executeQuery(query);
    ResultSetMetaData md = results.getMetaData();
    while (results.next()) {
        for (int i = 1; i <= md.getColumnCount(); ++i) {
        out.println(results.getString(i));
        }
    }
} catch (SQLException ex) {
    ex.printStackTrace();
}
```
