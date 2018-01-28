function retrieveProducts(categoryId) {
    var url = '/products';
    $("#productsBlock").load(url + '/' + categoryId);
}