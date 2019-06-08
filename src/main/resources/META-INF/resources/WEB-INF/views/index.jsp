<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/lib/bootstrap.min.css"/>
    <script type = "text/javascript" src = "/js/jquery-3.4.1.js"></script>
</head>
<body >
<div class="container">
    <div class="row">
        <div class="col-sm-2 col-md-2 col-lg-2">
            <form>
                <p>Services:</p>
                <div class="radio">
                    <label><input type="radio" name="service" value="/subscriber/create" checked>Create</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="service" value="/subscriber/update">Update</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="service" value="/subscriber/get">Get</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="service" value="/region/create">Region</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="service" value="/city/create">City</label>
                </div>
            </form>
        </div>
        <div class="col-sm-5 col-md-5 col-lg-5">
            <div class="form-group">
                <label for="jsonIn">Input Data:</label>
                <textarea class="form-control" rows="20" id="jsonIn"></textarea>
            </div>
        </div>
        <div class="col-sm-5 col-md-5 col-lg-5">
            <div class="form-group">
                <label for="jsonOut">Output Data:</label>
                <textarea class="form-control" rows="20" id="jsonOut"></textarea>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6 col-md-6 col-lg-6">
            <button id="submit" type="button" class="btn btn-success">Submit</button>
        </div>
    </div>
</div>

<script type = "text/javascript">
    $(document).ready(function() {

        var subscriber = {"id":2,"surname":"surname","name":"name","phone":"phone","regionId":1,"cityId":2};
        var city = {"id":2, "name":"city"};
        var region = {"id":2, "name":"region"};
        $('#jsonIn').val(JSON.stringify(subscriber));

        function send(service, passData) {
            $.ajax({
                url: service,
                type: 'post',
                dataType: 'json',
                contentType: 'application/json',
                success: function (data) {
                    $('#jsonOut').val(data);
                },
                data: passData
            });
        }
        function get(service) {
            $.getJSON(service, function(result){
                $('#jsonOut').val(JSON.stringify(result));
            });
        }

        $('#submit').click(function () {
            var service = $('input[name=service]:checked').val();
            $('#jsonOut').val('sending..');

            if(service.includes('get')){
                get(service + "/" + $('#jsonIn').val());
            } else {
                send(service, $('#jsonIn').val());
            }
        });

        $('input[name=service]').change(function(){
            var service = $('input[name=service]:checked').val();
            $('#jsonOut').val('sending..');

            if(service.includes('get')){
                $('#jsonIn').val(1);
            } else if(service.includes('city')){
                $('#jsonIn').val(JSON.stringify(city));
            } else if(service.includes('region')){
                $('#jsonIn').val(JSON.stringify(region));
            } else {
                $('#jsonIn').val(JSON.stringify(subscriber));
            }
        });

    });
</script>
</body>
</html>