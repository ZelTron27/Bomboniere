<?php
$servername="localhost";
$database="bomboniere";
$root="root";
$password="";

$conexao =new mysqli($servername, $root, $password, $database);

if ($conexao -> connect_error)  {
    die("Erro conexao". $conexao -> connect_error);
} else {

}
?>