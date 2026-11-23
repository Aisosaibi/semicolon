def mbti_test():
    responses = [];
    name = input("What is your name?\n")
    mbti_questions = ["Q1:  A. expend energy, enjoy groups        B. conserve energy, enjoy one-on-one\n", "Q2:  A. Interpret literally                B. look for meaning and possibilities\n", "Q3:  A. logical, thinking, questioning     B. empathetic, feeling, accommodating\n", "Q4:  A. organized, orderly                 B. flexible, adaptable\n", "Q5:  A. more outgoing, think out loud      B. more reserved, think to yourself\n", "Q6:  A. practical, realistic, experiential B. imaginative, innovative, theoretical\n", "Q7:  A. candid, straight forward, frank    B. tactful, kind, encouraging\n", "Q8:  A. plan, schedule                     B. unplanned, spontaneous\n", "Q9:  A. seek many tasks, public activities B. seek private, solitary activities\n", "Q10: A. standard, usual, conventional      B. different, novel, unique\n", "Q11: A. firm, tend to criticize            B. gentle, tend to appreciate, conciliate\n", "Q12: A. regulated, structured              B. easy-going, live and let live\n", "Q13: A. external, communicative            B. internal, reticent, keep to yourself\n", "Q14: A. focus on here-and-now             B. look to the future, global perspective\n", "Q15: A. tough-minded, just                 B. tender-hearted, merciful\n", "Q16: A. preparation, plan ahead            B. go with the flow, adapt as you go\n", "Q17: A. active, initiate                   B. reflective, deliberate\n", "Q18: A. facts, things, what is             B. ideas, dreams, what could be\n", "Q19: A. matter of fact, issue-oriented     B. sensitive, people-oriented, compassionate\n", "Q20: A. control, govern                    B. latitude, freedom\n"]
    valid_response = ["A", "a", "B", "b"]
    for index in range(len(mbti_questions)):
        response = input(mbti_questions[index])
        while response not in valid_response:
            response = input("Choose an option ('A' or 'B'): ")
        response = response.upper()
        responses.append(response)
        
    return name, responses

def score_dimension(answers, letter_a, letter_b):
    a_count = answers.count("A")
    b_count = answers.count("B")
    return letter_a if a_count >= b_count else letter_b

def mbti_result(name, responses):
    e_vs_i = []
    s_vs_n = []
    t_vs_f = []
    j_vs_p = []
    
    EI_INDICES = [0, 4, 8, 12, 16]
    SN_INDICES = [1, 5, 9, 13, 17]
    TF_INDICES = [2, 6, 10, 14, 18]
    JP_INDICES = [3, 7, 11, 15, 19]

    e_vs_i = [responses[i] for index in EI_INDICES] #list comprehension
    s_vs_n = [responses[i] for index in SN_INDICES]
    t_vs_f = [responses[i] for index in TF_INDICES]
    j_vs_p = [responses[i] for index in JP_INDICES]

    return e_vs_i, s_vs_n, t_vs_f, j_vs_p


def display_mbti_result(name, e_vs_i, s_vs_n, t_vs_f, j_vs_p):
    E_or_I = score_dimension(e_vs_i, "E", "I")
    S_or_N = score_dimension(s_vs_n, "S", "N")
    T_or_F = score_dimension(t_vs_f, "T", "F")
    J_or_P = score_dimension(j_vs_p, "J", "P")
    personality_type = E_or_I + S_or_N + T_or_F + J_or_P

    print(f"\nHello, {name}. Your personality type is: {personality_type}")


    


#I was thinking of storing the questions in an array and showing them at random to the user, while keeping track of which question is being answered and storing the answers... Maybe I will do that, but let's do one
    
