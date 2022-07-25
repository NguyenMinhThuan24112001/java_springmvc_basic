<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:redirect url="/trang-chu"/>
<%--khi start hệ thống lên, nó nhảy vào file này và thấy redirect đến url="/trang-chu/"--%>
<%--do đó nó sẽ apply url này, chạy vào controller để xem url này áp dụng cho file nào đc hiển thị--%>

<%--chữ c trong c:redirect là ở dòng prefix = "c" do thư viện jstl cung cấp--%>