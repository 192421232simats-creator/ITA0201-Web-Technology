<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>IT Help Desk</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f1f5f9;
            margin: 0;
            padding: 40px;
        }

        .form-box {
            width: 520px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.15);
        }

        h1 {
            text-align: center;
            color: #3949ab;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input, select, textarea {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            box-sizing: border-box;
            border: 1px solid #aaa;
            border-radius: 6px;
        }

        textarea {
            height: 100px;
            resize: vertical;
        }

        .priority {
            margin-top: 10px;
        }

        .priority label {
            display: inline;
            margin-right: 15px;
            font-weight: normal;
        }

        .priority input {
            width: auto;
        }

        button {
            width: 100%;
            padding: 12px;
            margin-top: 25px;
            background: #3949ab;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background: #283593;
        }
    </style>
</head>

<body>

<div class="form-box">

    <h1>IT Help Desk Request</h1>

    <form action="SupportTicketServlet" method="post">

        <label>Employee Code</label>
        <input type="text" name="employeeCode" required>

        <label>Employee Name</label>
        <input type="text" name="employeeName" required>

        <label>Department</label>
        <input type="text" name="department" required>

        <label>Problem Type</label>
        <select name="problemType" required>
            <option value="">Select Problem</option>
            <option value="Network">Network</option>
            <option value="Software">Software</option>
            <option value="Hardware">Hardware</option>
            <option value="Account">Account</option>
            <option value="Other">Other</option>
        </select>

        <label>Problem Details</label>
        <textarea name="problemDetails"
                  placeholder="Describe your problem"
                  required></textarea>

        <label>Priority Level</label>

        <div class="priority">
            <label>
                <input type="radio"
                       name="priorityLevel"
                       value="Low"
                       required>
                Low
            </label>

            <label>
                <input type="radio"
                       name="priorityLevel"
                       value="Medium">
                Medium
            </label>

            <label>
                <input type="radio"
                       name="priorityLevel"
                       value="High">
                High
            </label>
        </div>

        <button type="submit">
            Submit Support Request
        </button>

    </form>

</div>

</body>
</html>