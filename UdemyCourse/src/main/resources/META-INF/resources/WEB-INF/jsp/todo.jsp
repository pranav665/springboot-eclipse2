
<%@ include file="common/header.jspf"%>

<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div class="container">
		<h1>Enter Todo Details</h1>

		<div class="container">
			<form:form method="post" modelAttribute="todo">

				<fieldset class="mb-3">
					<form:label path="description">description</form:label>
					<form:input type="text" path="description" required="required" />
					<form:errors path="description" cssClass="text-warning" />
				</fieldset>

				<fieldset class="mb-3">
					<form:label path="targetDate">targetDate</form:label>
					<form:input type="text" path="targetDate" required="required" />
					<form:errors path="targetDate" cssClass="text-warning" />
				</fieldset>

				<form:input type="hidden" path="done" />
				<form:input type="hidden" path="id" />
				<input type="submit" class="btn btn-success" />

			</form:form>
		</div>
	</div>

<%@ include file="common/footer.jspf"%>
<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'yyyy-mm-dd'
		});
	</script>


