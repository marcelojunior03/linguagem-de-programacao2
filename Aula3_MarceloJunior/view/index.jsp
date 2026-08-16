<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>InfoTec</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }

        h1 {
            text-align: center;
        }

        .produtos {
            display: flex;
            justify-content: center;
            gap: 30px;
            flex-wrap: wrap;
        }

        .produto {
            width: 220px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            text-align: center;
        }

        .produto img {
            width: 180px;
            height: 130px;
            object-fit: contain;
        }

        .preco {
            font-size: 20px;
            font-weight: bold;
        }

        button {
            padding: 10px 20px;
            margin-top: 20px;
            cursor: pointer;
        }
    </style>
</head>

<body>

<h1>InfoTec</h1>

<form action="carrinho" method="post">

    <div class="produtos">

        <div class="produto">
            <img src="https://cdn.awsli.com.br/954/954868/produto/68627041/40c163f71e.jpg">

            <h3>Notebook Dell</h3>

            <p>Notebook Dell com processador Intel Core i5.</p>

            <p class="preco">R$ 3.500,00</p>

            <label>
                <input type="checkbox"
                       name="produto"
                       value="1">
                Comprar
            </label>
        </div>


        <div class="produto">
            <img src="https://www.lognetinfo.com.br/imagens/original/23359A.jpg">

            <h3>Teclado Mecânico</h3>

            <p>Teclado mecânico RGB para jogos.</p>

            <p class="preco">R$ 250,00</p>

            <label>
                <input type="checkbox"
                       name="produto"
                       value="2">
                Comprar
            </label>
        </div>


        <div class="produto">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNV8cNEjLFJfdqr4donIbmPieW8bWnS4rpGFxy5_6WlA&s=10">

            <h3>Mouse Gamer</h3>

            <p>Mouse gamer com sensor de alta precisão.</p>

            <p class="preco">R$ 150,00</p>

            <label>
                <input type="checkbox"
                       name="produto"
                       value="3">
                Comprar
            </label>
        </div>


        <div class="produto">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8BG0Pnji6VH5MnMyeJjCkUVMMlmknyq4FFv1IzHCd6QTkhfWWy4KWhN-P&s=10">

            <h3>Monitor 24"</h3>

            <p>Monitor Full HD de 24 polegadas.</p>

            <p class="preco">R$ 900,00</p>

            <label>
                <input type="checkbox"
                       name="produto"
                       value="4">
                Comprar
            </label>
        </div>

    </div>

    <div style="text-align:center;">
        <button type="submit">
            Fechar Carrinho
        </button>
    </div>

</form>

</body>
</html>