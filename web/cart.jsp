<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">


        <title>bs4 cart - Bootdey.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <style type="text/css">
            body{
                margin-top:20px;
                background:#eee;
            }
            .ui-w-40 {
                width: 40px !important;
                height: auto;
            }

            .card{
                box-shadow: 0 1px 15px 1px rgba(52,40,104,.08);
            }

            .ui-product-color {
                display: inline-block;
                overflow: hidden;
                margin: .144em;
                width: .875rem;
                height: .875rem;
                border-radius: 10rem;
                -webkit-box-shadow: 0 0 0 1px rgba(0,0,0,0.15) inset;
                box-shadow: 0 0 0 1px rgba(0,0,0,0.15) inset;
                vertical-align: middle;
            }
        </style>
    </head>
    <body>
        <div class="container px-3 my-5 clearfix">

            <div class="card">
                <div class="card-header">
                    <h2>Shopping Cart</h2>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered m-0">
                            <thead>
                                <tr>

                                    <th class="text-center py-3 px-4" style="min-width: 400px;">Product Name</th>
                                    <th class="text-right py-3 px-4" style="width: 100px;">Price</th>
                                    <th class="text-center py-3 px-4" style="width: 120px;">Quantity</th>
                                    <th class="text-right py-3 px-4" style="width: 100px;">Total</th>
                                    <th class="text-center align-middle py-3 px-0" style="width: 40px;"><a href="#" class="shop-tooltip float-none text-light" title data-original-title="Clear cart"><i class="ino ion-md-trash"></i></a></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${carts}" var="c">
                                <form action="update-amount">
                                    <tr>
                                        <td class="p-4">
                                            <div class="media align-items-center">
                                                <img src="${c.value.getProduct().getImage()}" class="d-block ui-w-40 ui-bordered mr-4" alt>
                                                <div class="media-body">
                                                    <a href="#" class="d-block text-dark">${c.value.getProduct().getName()}</a>
                                                    <c:if test="${c.value.getProduct().getId() == pid}">${ms}</c:if>       
                                                </div>
                                            </div>
                                        </td>
                                        <input type="hidden" name="productId" value="${c.value.getProduct().getId()}"/>
                                        <td class="text-right font-weight-semibold align-middle p-4">$${c.value.getProduct().getPrice()}</td>
                                        <td class="align-middle p-4"><input onchange="this.form.submit()" type="number" name="amount" class="form-control text-center" value="${c.value.getAmount()}" min="1"></td>
                                        <td class="text-right font-weight-semibold align-middle p-4">$${c.value.getProduct().getPrice()*c.value.getAmount()}</td>
                                        <td class="text-center align-middle px-0"><a href="delete-product-cart?pId=${c.value.getProduct().getId()}" class="shop-tooltip close float-none text-danger" title data-original-title="Remove">×</a></td>
                                    </tr>
                                </form>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>

                    <div class="d-flex flex-wrap justify-content-between align-items-center pb-4">
                        <div class="mt-4">

                        </div>
                        <div class="d-flex">
                            <div class="text-right mt-4 mr-5">

                            </div>
                            <div class="text-right mt-4">
                                <label class="text-muted font-weight-normal m-0">Total price</label>
                                <div class="text-large"><strong>$${total}</strong></div>
                            </div>
                        </div>
                    </div>
                    <div class="float-right">
                        <a href="backHome"><button type="button" class="btn btn-lg btn-default md-btn-flat mt-2 mr-3">Back to shopping</button></a>
                        <a href="thankYou"><button type="button" class="btn btn-lg btn-primary mt-2">Checkout</button></a>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript">

        </script>
    </body>
</html>