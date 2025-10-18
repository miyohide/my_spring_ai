プロジェクト内でSpring Frameworkを使ったコーディングを行う際は下記ルールに従ってください。

# 全般

- コンストラクタインジェクションを使ってください。フィールドインジェクションは使用しないでください。

# 生成するファイルのパッケージについて

Spring Bootアプリケーションで必要な各ファイルは下記のパッケージに
`src\main\java\com\example\springaiapp`配下に下記パッケージを配置してください。
それぞれのパッケージがない場合は新規作成してください

## パッケージ一覧

- Controller：Controllerクラスを格納してください。
- Service：Serviceクラスを格納してください。
- Repository：Repositoryクラスを格納してください。
