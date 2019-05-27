<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>jQuery File Upload Example</title>
</head>
<body>
<input id="fileupload" type="file" name="files[]" data-url="fileDatas" multiple>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="/lib/jquery.ui.widget.js"></script>
<script src="/lib/jquery.iframe-transport.js"></script>
<script src="/lib/jquery.fileupload.js"></script>
<script>
$(function () {
    $('#fileupload').fileupload({
        maxChunkSize: 10000000, // 10 MB
        add: function (e, data) {
            var that = this;
            $.getJSON('server/php/', {file: data.files[0].name}, function (result) {
                var file = result.file;
                data.uploadedBytes = file && file.size;
                $.blueimp.fileupload.prototype
                    .options.add.call(that, e, data);
            });
        }
    });
});
</script>
</body> 
</html>