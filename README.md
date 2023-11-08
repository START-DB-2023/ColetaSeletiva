![start-db-logo](https://github.com/gustavo-p0/desafio_db_grupo_03/assets/83771792/a51463ab-3015-4036-8a3c-3d6f6b7ef945)

# Desafio Start DB Grupo 03

Integrantes do time:

> Aurora Kruschewsky

> Ajadne Vacineski

> Gustavo Costa

## Descrição do sistema

A coleta seletiva é um processo de recolhimento de materiais recicláveis que são separados na fonte geradora. Esses materiais incluem papel/papelão, plástico/isopor, vidro, metal, madeira, resíduos perigosos/contaminados, radioativos, orgânicos, eletrônicos e misturados. Pessoas interessadas em fazer descarte seletivo desejam encontrar pontos de coleta específicos para cada tipo de resíduo. Por outro lado, instituições responsáveis pela administração desses pontos de coleta buscam divulgá-los para facilitar o correto descarte dos resíduos.

Cada ponto de coleta possui informações úteis para o descarte e é gerenciado por uma administradora.

Cada resíduo possui uma descrição, uma cor e um nome associado a ele. 

O mapa de pontos de coleta permite que as pessoas interessadas localizem o endereço e o horário de funcionamento de um ponto específico. Em alguns casos, as pessoas já conhecem os locais de descarte e podem se dirigir diretamente a eles. No entanto, em outras situações, as pessoas podem precisar descartar um tipo de resíduo com o qual não estão familiarizadas, e nesse caso, elas precisam de ajuda para encontrar locais especializados para o descarte desse material.

Cada ponto é caracterizado por um nome, horário de funcionamento, dias de operação, localização e tipos de materiais que são aceitos. 

O sistema desenvolvido deve ser capaz de, no mínimo, permitir a listagem e a filtragem dos pontos de coleta com base no tipo de material aceito, na região de atuação e nos dias de funcionamento. Também será possível cadastrar instituições administradoras e novos pontos de coleta.

## Requisitos

- RF-001 | Permitir o cadastro de uma instituição administradora
- RF-002 | Permitir o cadastro de diferentes tipos de resíduos
- RF-003 | Permitir a edição de um tipo de resíduo
- RF-004 | Permitir a exclusão de um tipo de resíduo
- RF-003 | Permitir o cadastro de pontos de coleta
- RF-004 | Permitir a edição de pontos de coleta
- RF-005 | Permitir o fechamento de pontos de coleta
- RF-004 | Permitir que o usuário visualize todos os pontos de coleta
- RF-005 | Permitir que o usuário filtre os pontos de coleta por materiais
- RF-007 | Permitir que o usuário filtre os pontos de coleta por localização
- RF-008 | Permitir que o usuário filtre os pontos de coleta por horário de funcionamento
- RF-009 | Permitir que o usuário filtre os pontos de coleta por dias de funcionamento
- RF-010 | Permitir que o usuário visualizar os pontos de coleta em um mapa
- RF-011 | Permitir a visualização das instituições administradora

## Requisitos não funcionais

- RNF-001 | O sistema deve ser uma API REST desenvolvida com SpringBoot
- RNF-002 | O sistema deve ser ter como cliente uma aplicação web desenvolvida com React
- RNF-003 | Pontos de coleta desativados não devem ser apagados dos dados dentro de um mês
- RNF-004 | A plataforma deve ter recursos de acessibilidade
