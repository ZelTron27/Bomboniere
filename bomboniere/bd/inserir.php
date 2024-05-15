<?php
require_once 'conexao.php';

function senhaForte($senha) {
    // Verifica se a senha tem pelo menos 8 caracteres
    if (strlen($senha) < 8) {
        return false;
    }

    // Verifica se a senha contém pelo menos uma letra maiúscula
    if (!preg_match('/[A-Z]/', $senha)) {
        return false;
    }

    // Verifica se a senha contém pelo menos uma letra minúscula
    if (!preg_match('/[a-z]/', $senha)) {
        return false;
    }

    // Verifica se a senha contém pelo menos um número
    if (!preg_match('/[0-9]/', $senha)) {
        return false;
    }

    // A senha é forte o suficiente
    return true;
}

if($_POST) {
    $nome = $_POST['nome'];
    $email = $_POST['email'];
    $senha = $_POST['senha'];

    // Verifica se a senha é forte o suficiente
    if (!senhaForte($senha)) {
        echo "<h1 style='color: red;'>Senha Fraca</h1>";
        echo "<p>A senha deve conter pelo menos 8 caracteres, incluindo letras maiúsculas, minúsculas e números.</p>";
        echo "<a href='../cadastrar.html'>Voltar para a página de cadastro</a>";
        exit; // Interrompe o script, impedindo a inserção no banco de dados
    }

    // Escapa os dados para evitar injeção de SQL
    $nome = $conexao->real_escape_string($nome);
    $email = $conexao->real_escape_string($email);
    $senha = $conexao->real_escape_string($senha);

    $sql = "INSERT INTO usuarios (nome, email, senha) VALUES ('$nome', '$email', '$senha')";
    if ($conexao->query($sql)) {
        echo "<h1 style='color: green;'>Cadastro Confirmado</h1>";
        echo "<p>O cadastro foi realizado com sucesso.</p>";
        echo "<script>window.location.href='../produtos.html';</script>";
    } else {
        echo "Erro: " . $conexao->error;
    }

    $conexao->close();
}
?>
