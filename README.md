# Introduzione alla programmazione per il web

## Snippets per cose importanti

### Derby
La prima cosa da fare è pregare che Netbeans e Derby siano installati dritti. Appurato questo, è sufficiente:
* naviagare sulla tab _services_ di Netbeans
* espandere il campo _Database_
* right click on _JavaDB_
* creare un nuovo database con un nome, uno username e una password
* assicurarsi di avviare la connessione al database

Buono, adesso c'è il database. È possibile creare tabelle e inserire delle entries in maniera piuttosto comoda dall'editor di Netbeans, così come anche eseguire dei comandi SQL. Forse quest'ultimo approccio è più conveniente, perché così possiamo salvare i vari `CREATE TABLE YOLO` e `INSERT INTO BLABLABLA` in un file e poter ricreare il database agevolmente in caso qualcosa andasse storto.

Passiamo al codice. Conviene prepararsi fin da subito le credenziali di accesso al database:
```java
private String dbURL = "jdbc:derby://localhost:1527<nomeDB>";
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
* prepariamo un oggetto `Statement` utilizzando il metodo `createStatement()` della connessione
* utilizziamo il metodo `executeQuery(String query)` dello statement per eseguire una query, che sarà una stringa scritta nel linguaggio opportuno
* il ritorno di `executeQuery()` sarà un'istanza di un oggetto `ResultSet`
  
Pare sia opportuno eseguire le query all'interno di un blocco `try-catch`.

```java
// ...
// PrintWriter out = abbiamo un PrintWriter
try {
    Statement stmt = conn.createStatement();
    String query = "SELECT * FROM SOME_TABLE;";
    ResultSet results = stmt.executeQuery(query);
    ResultSetMetaData md = results.getMetaData();
    while (results.next()) {
        for (int i = 1; i <= md.getColumnCount(); ++i) {
        out.println(results.getString(i));
        }
    }
} catch (SQLException ex) {
    out.println("Exception caught!");
}
```