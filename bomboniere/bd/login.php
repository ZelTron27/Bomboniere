<?php
session_start();

// Verifica se já houve tentativas de login
if (!isset($_SESSION['login_attempts'])) {
    $_SESSION['login_attempts'] = 0;
}

$max_attempts = 3; // Número máximo de tentativas permitidas

// Se excedeu o número máximo de tentativas, bloqueia o login por 5 minutos
if ($_SESSION['login_attempts'] >= $max_attempts && isset($_SESSION['last_login_attempt'])) {
    if (time() - $_SESSION['last_login_attempt'] < 15) { // 300 segundos = 5 minutos
        echo "Número máximo de tentativas excedido. Tente novamente em 5 minutos.";
        exit();
    } else {
        // Resetar tentativas após o período de bloqueio
        $_SESSION['login_attempts'] = 0;
        unset($_SESSION['last_login_attempt']);
    }
}

// Conexão com o banco de dados
$conexao = new mysqli("localhost", "root", "", "bomboniere");

// Verifica conexão
if ($conexao->connect_error) {
    die("Erro na conexão: " . $conexao->connect_error);
}

// Captura dados do formulário
$email = $_POST['email'];
$senha = $_POST['senha'];

// Consulta SQL para verificar se o usuário existe
$sql = "SELECT * FROM usuarios WHERE email='$email' AND senha='$senha'";
$resultado = $conexao->query($sql);

if ($resultado->num_rows > 0) {
    // Login bem-sucedido
    $_SESSION['email'] = $email;
    $_SESSION['login_attempts'] = 0; // Resetar tentativas bem-sucedidas
    unset($_SESSION['last_login_attempt']);
    header("Location: ../produtos.html"); // Redireciona para a página do usuário
} else {
    // Login falhou
    $_SESSION['login_attempts']++;
    if (!isset($_SESSION['last_login_attempt'])) {
        $_SESSION['last_login_attempt'] = time();
    }
    echo "E-mail ou senha incorretos. Tentativa " . $_SESSION['login_attempts'] . " de " . $max_attempts;
}
$conexao->close();
?>