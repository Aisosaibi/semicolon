time1= input("Initial Time (hh:mm): ")
parts1 = time1.split(":")
hour1 = int(parts1[0])
minute1 = int(parts1[1])

time2 = input("Time Since (hh:mm): ")
parts2 = time2.split(":")
hour2 = int(parts2[0])
minute2 = int(parts2[1])

sum_minutes = minute1 + minute2
sum_hours = hour1 + hour2

if sum_minutes >= 60:
    sum_hours += sum_minutes // 60   # carry the extra hour(s)
    sum_minutes = sum_minutes % 60

sum_hours = sum_hours % 24

print("The total time is %02d:%02d" % (sum_hours, sum_minutes))
