# teste globo play
  O projeto consiste em exibir uma lista de programas que é consumida de um json feito no Apiary.io,
  o endpoint utilizado foi o : **http://private-95c9d-testegloboplay.apiary-mock.com/videos** .
  
  **Para utilizá-lo, basta clonar o repositório e fazer checkout da branch develop.**

Desenvolvido em clean, o app possui três módulos, sendo eles: domain, data e app. 
  
  **Domain Module:**</br>
  Responsável por criar um modelo de um Programa e conter o caso de uso que mapeia e retorna uma 
  lista de programas.</br>
  **Data Module:** </br> Utilizando o retrofit é criado um client e um service para realizar o request.</br>
  **App Module:** </br> Com libs de design nativas do Android, se conecta com as duas outras camadas,
  exibindo de maneira simples a lista de programas que foi recebida, deixando também o usuário 
  acessar um conteúdo e ver mais informações sobre o mesmo.</br>
  
  _Libraries utilizadas:_
  **Foi utilizado um arquivo de dependecies para melhor organização**
  
    kotLin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    design = "com.android.support:design:${supportLibraryVersion}"
    appCompat = "com.android.support:appcompat-v7:${supportLibraryVersion}"
    support = "com.android.support:support-v4:${supportLibraryVersion}"
    cardview = "com.android.support:cardview-v7:${supportLibraryVersion}"
    supportTransitions = "com.android.support:transition:${supportLibraryVersion}"
    constraintLayout = "com.android.support.constraint:constraint-layout:1.1.1"
    recycleView = "com.android.support:recyclerview-v7:${supportLibraryVersion}"

    retrofit = "com.squareup.retrofit2:retrofit:2.4.0"
    retrofitConverter = "com.squareup.retrofit2:converter-gson:2.4.0"

    glide = "com.github.bumptech.glide:glide:${glideVersion}"
    glideAnnotation = "com.github.bumptech.glide:compiler:${glideVersion}"

    multidex = "com.android.support:multidex:1.0.3"

    jUnit = "junit:junit:4.12"
    mockito = "org.mockito:mockito-core:2.10.0"
   
