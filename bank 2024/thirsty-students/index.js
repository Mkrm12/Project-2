const express = require("express");
const ejs = require("ejs");
const bodyParser = require("body-parser");

const app = express();
const port = 8000;

app.use(express.static("public"));
app.use(bodyParser.urlencoded({ extended: true }));



app.set("views", __dirname + "/views");
app.set("view engine", "ejs");
app.engine("html", ejs.renderFile);

app.get("/", (req, res) => {
  res.render("index.ejs");
});

app.get("/how-It-works", (req, res) => {
  res.render("howItworks.ejs");
});
app.get("/contact", (req, res) => {
  res.render("contactUs.ejs");
});

app.get("/register", (req, res) => {
  res.render("register.ejs");
});
app.get("/login", (req, res) => {
  res.render("login.ejs");
});
app.post('/login', (req, res) => {

  res.redirect('/dashboard');
});

app.get("/dashboard", (req, res) => {
  res.render("dashboard.ejs");
});

app.post("/registered", (req, res) => {
  // Saving data in the database would typically happen here
  res.send(
    `Hello ${req.body.first} ${req.body.last}, you are now registered! We will be sending an email to you at ${req.body.email}`
  );
});

app.listen(port, () => console.log(`App listening on port ${port}!`));
