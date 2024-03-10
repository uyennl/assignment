<%-- 
    Document   : index
    Created on : Mar 6, 2024, 2:22:52 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PIZZA ORDER</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </head>
    <body>
        <!--      NavBar-->
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <!--logo-->
                <a class="navbar-brand" href="#">
                    <img src="data:image/jpeg;base64,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" alt="Bootstrap" width="50" height="40">
                </a>
                <!--                 end logo-->
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Combo giảm giá</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                MENU
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Món ăn chính</a></li>
                                <li><a class="dropdown-item" href="#">Món ăn phụ</a></li>
                                <li><a class="dropdown-item" href="#">Tráng miệng</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Nước</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" aria-disabled="true">Hết hàng</a>
                        </li>
                    </ul>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Nội dung tìm kiếm" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Tìm</button>
                        <button><a class ="btn btn-outline-success" style="white-space: nowrap; margin-left:5px;" href="login.jsp">
                                Đăng nhập
                            </a></button>
                    </form>
                </div>
            </div>
        </nav> 
        <!--Navbar-->
        <!--        Page content-->
        <div class ="container">
            <div class = "row">
                <!--                Menu Left-->
                <div class="col-lg-3">
                    <div class="list-group">
                        <a href="#" class="list-group-item list-group-item-action">
                            Pizza
                        </a>
                        <a href="#" class="list-group-item list-group-item-action">Hamburger</a>
                        <a href="#" class="list-group-item list-group-item-action">Hot Dog</a>
                        <a href="#" class="list-group-item list-group-item-action">Bánh mì</a>
                        <a href="#" class="list-group-item list-group-item-action">Gà rán</a>
                        <!-- Thêm các loại thức ăn nhanh khác tùy theo nhu cầu -->
                    </div>
                </div>

                <!--                End Menu Left-->

                <!--Slider Product-->
                <div class = "col-lg-9">
                    <!--Slider             -->
                    <div id="carouselExampleIndicators" class="carousel slide">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="https://www.pizzaproject.nl/wp-content/uploads/1-Neapolitan-Pizza-Bar.jpg" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img src="https://www.pizzaproject.nl/wp-content/uploads/TannoWitkamp-F-1025x390.jpg" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img src="https://www.andrewspizzas.com/images/slideshow/slide1.webp" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <!--End Slider-->
                    <!--product-->
                    <div class="row">
                        <div class="card col-lg-4">
                            <img src="https://www.southernliving.com/thmb/3x3cJaiOvQ8-3YxtMQX0vvh1hQw=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/2652401_QFSSL_SupremePizza_00072-d910a935ba7d448e8c7545a963ed7101.jpg" class="card-img-top" alt="Pizza Hawaii">
                            <div class="card-body">
                                <h5 class="card-title">Pizza Hawaii</h5>
                                <p class="card-text">Một chiếc pizza hawaii thơm ngon với lớp phô mai tan chảy, thêm vị ngọt của dứa và vị chua của sốt cà chua.</p>
                                <a href="#" class="btn btn-primary">Mua</a>
                            </div>
                        </div>
                        <div class="card col-lg-4">
                            <img src="https://www.youtubers.cooking/wp-content/uploads/2022/04/pizza-youtubers-cooking.jpg" class="card-img-top" alt="Pizza Margherita">
                            <div class="card-body">
                                <h5 class="card-title">Pizza Margherita</h5>
                                <p class="card-text">Một chiếc pizza Margherita truyền thống với lớp phô mai mozzarella, cà chua tươi và lá rau thơm mát basil.</p>
                                <a href="#" class="btn btn-primary">Mua</a>
                            </div>
                        </div>
                        <div class="card col-lg-4">
                            <img src="https://www.allrecipes.com/thmb/iXKYAl17eIEnvhLtb4WxM7wKqTc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/240376-homemade-pepperoni-pizza-Beauty-3x4-1-6ae54059c23348b3b9a703b6a3067a44.jpg" class="card-img-top" alt="Pizza Pepperoni">
                            <div class="card-body">
                                <h5 class="card-title">Pizza Pepperoni</h5>
                                <p class="card-text">Một chiếc pizza Pepperoni đậm đà với lớp phô mai vàng ươm, pepperoni cay nồng và sốt cà chua đậm đà.</p>
                                <a href="#" class="btn btn-primary">Mua</a>
                            </div>
                        </div>
                    </div>


                    <!--end product-->
                </div>
                <!--End Slider Product-->
                <footer class="py-3 my-4">
                    <ul class="nav justify-content-center border-bottom pb-3 mb-3">
                        <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Home</a></li>
                        <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Features</a></li>
                        <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Pricing</a></li>
                        <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">FAQs</a></li>
                        <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">About</a></li>
                    </ul>
                    <p class="text-center text-body-secondary">© 2023 Company, Inc</p>
                </footer>
            </div>
        </div>
    </body>
</html>