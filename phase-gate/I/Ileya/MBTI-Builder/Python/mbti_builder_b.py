def mbti_test():
    responses = []
    name = input("What is your name?\n")
    mbti_questions = [
        ["expend energy, enjoy groups", "conserve energy, enjoy one-on-one"],
        ["interpret literally", "look for meaning and possibilities"],
        ["logical, thinking, questioning", "empathetic, feeling, accommodating"],
        ["organized, orderly", "flexible, adaptable"],
        ["more outgoing, think out loud", "more reserved, think to yourself"],
        ["practical, realistic, experiential", "imaginative, innovative, theoretical"],
        ["candid, straight forward, frank", "tactful, kind, encouraging"],
        ["plan, schedule", "unplanned, spontaneous"],
        ["seek many tasks, public activities", "seek private, solitary activities"],
        ["standard, usual, conventional", "different, novel, unique"],
        ["firm, tend to criticize", "gentle, tend to appreciate, conciliate"],
        ["regulated, structured", "easy-going, live and let live"],
        ["external, communicative", "internal, reticent, keep to yourself"],
        ["focus on here-and-now", "look to the future, global perspective"],
        ["tough-minded, just", "tender-hearted, merciful"],
        ["preparation, plan ahead", "go with the flow, adapt as you go"],
        ["active, initiate", "reflective, deliberate"],
        ["facts, things, what is", "ideas, dreams, what could be"],
        ["matter of fact, issue-oriented", "sensitive, people-oriented, compassionate"],
        ["control, govern", "latitude, freedom"]
    ]
    valid_response = ["A", "a", "B", "b"]
    for index in range(len(mbti_questions)):
        a_side = mbti_questions[index][0]
        b_side = mbti_questions[index][1]
        print(f"Q{index + 1}: A. {a_side}    B. {b_side}")
        response = input("Your answer: ")
        while response.strip() not in valid_response:
            response = input("Choose an option ('A' or 'B'): ")
        response = response.upper()
        responses.append(response)
    return name, responses, mbti_questions


def score_dimension(response_category, option_a, option_b):
    a_count = response_category.count("A")
    b_count = response_category.count("B")
    return option_a if a_count >= b_count else option_b


def mbti_result(name, responses, mbti_questions):
    EI_INDICES = [0, 4, 8, 12, 16]
    SN_INDICES = [1, 5, 9, 13, 17]
    TF_INDICES = [2, 6, 10, 14, 18]
    JP_INDICES = [3, 7, 11, 15, 19]

    e_vs_i = [responses[index] for index in EI_INDICES] #list comprehension
    s_vs_n = [responses[index] for index in SN_INDICES]
    t_vs_f = [responses[index] for index in TF_INDICES]
    j_vs_p = [responses[index] for index in JP_INDICES]

    E_or_I = score_dimension(e_vs_i, "E", "I")
    S_or_N = score_dimension(s_vs_n, "S", "N")
    T_or_F = score_dimension(t_vs_f, "T", "F")
    J_or_P = score_dimension(j_vs_p, "J", "P")
    personality_type = E_or_I + S_or_N + T_or_F + J_or_P

    print(f"\nHello, {name}. You selected:")

    for index in EI_INDICES:
        choice = responses[index]
        side = 0 if choice == "A" else 1
        print(f"{choice}. {mbti_questions[index][side]}")

    print("\n")
    for index in SN_INDICES:
        choice = responses[index]
        side = 0 if choice == "A" else 1
        print(f"{choice}. {mbti_questions[index][side]}")

    print("\n")
    for index in TF_INDICES:
        choice = responses[index]
        side = 0 if choice == "A" else 1
        print(f"{choice}. {mbti_questions[index][side]}")

    print("\n")
    for index in JP_INDICES:
        choice = responses[index]
        side = 0 if choice == "A" else 1
        print(f"{choice}. {mbti_questions[index][side]}")

    print(f"\nYour personality type: {personality_type}")
    return personality_type

#def show_more_info(personality_type):
#    if personality_type == "INFP":
#        print("""The INFP Personality Type""")
#    elif personality_type == "":
#        print("""The ___ Personality Type""")
#    elif personality_type == "IS"
#        print("""The ___ Personality Type""")
#    else:
#        print("""The ___ Personality Type""")

name, responses, mbti_questions = mbti_test()
show_more_info(mbti_result(name, responses, mbti_questions))


#I'd like it to be able to display the questions at random without repeating and display it in the random order it was answered.
