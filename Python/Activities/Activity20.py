# Import pandas, ExcelFile and ExcelWriter
import pandas

dataframe = pandas.read_excel("../inputs/employee.xlsx")
# Print the full data
print(dataframe)

# Print number of rows and columns
print("Number of rows and columns in the table", dataframe.shape)

# Print data from the email column
print(dataframe['Email'])

# Sort data from First name
print("Sorted data on FirstName")
print(dataframe.sort_values('FirstName'))