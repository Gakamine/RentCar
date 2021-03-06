PGDMP     7                    y           postgres    13.3    13.2 a    0           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            1           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            2           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            3           1262    13442    postgres    DATABASE     d   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'French_France.1252';
    DROP DATABASE postgres;
                postgres    false            4           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3123                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            5           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            ?            1259    18204    adresse    TABLE     ?   CREATE TABLE public.adresse (
    id_adresse integer NOT NULL,
    rue character varying NOT NULL,
    code_postal character varying NOT NULL
);
    DROP TABLE public.adresse;
       public         heap    postgres    false            ?            1259    18202    adresse_id_adresse_seq    SEQUENCE     ?   CREATE SEQUENCE public.adresse_id_adresse_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.adresse_id_adresse_seq;
       public          postgres    false    202            6           0    0    adresse_id_adresse_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.adresse_id_adresse_seq OWNED BY public.adresse.id_adresse;
          public          postgres    false    201            ?            1259    18241    agence    TABLE       CREATE TABLE public.agence (
    id_agence integer NOT NULL,
    nom character varying NOT NULL,
    numtelephone character varying NOT NULL,
    id_adresse integer NOT NULL,
    gps_lat numeric NOT NULL,
    gps_long numeric NOT NULL,
    nbmaxvehicule integer NOT NULL
);
    DROP TABLE public.agence;
       public         heap    postgres    false            ?            1259    18239    agence_id_agence_seq    SEQUENCE     ?   CREATE SEQUENCE public.agence_id_agence_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.agence_id_agence_seq;
       public          postgres    false    208            7           0    0    agence_id_agence_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.agence_id_agence_seq OWNED BY public.agence.id_agence;
          public          postgres    false    207            ?            1259    18396    categorie_carburant    TABLE     ?   CREATE TABLE public.categorie_carburant (
    id_carburant integer NOT NULL,
    type character varying NOT NULL,
    prix money NOT NULL
);
 '   DROP TABLE public.categorie_carburant;
       public         heap    postgres    false            ?            1259    18394 $   categorie_carburant_id_carburant_seq    SEQUENCE     ?   CREATE SEQUENCE public.categorie_carburant_id_carburant_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public.categorie_carburant_id_carburant_seq;
       public          postgres    false    218            8           0    0 $   categorie_carburant_id_carburant_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public.categorie_carburant_id_carburant_seq OWNED BY public.categorie_carburant.id_carburant;
          public          postgres    false    217            ?            1259    18225    categorie_vehicule    TABLE     ?   CREATE TABLE public.categorie_vehicule (
    id_catvehicule integer NOT NULL,
    type character varying NOT NULL,
    tarif money NOT NULL
);
 &   DROP TABLE public.categorie_vehicule;
       public         heap    postgres    false            ?            1259    18223 %   categorie_vehicule_id_catvehicule_seq    SEQUENCE     ?   CREATE SEQUENCE public.categorie_vehicule_id_catvehicule_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 <   DROP SEQUENCE public.categorie_vehicule_id_catvehicule_seq;
       public          postgres    false    206            9           0    0 %   categorie_vehicule_id_catvehicule_seq    SEQUENCE OWNED BY     o   ALTER SEQUENCE public.categorie_vehicule_id_catvehicule_seq OWNED BY public.categorie_vehicule.id_catvehicule;
          public          postgres    false    205            ?            1259    18412    client    TABLE     ?   CREATE TABLE public.client (
    id_client integer NOT NULL,
    id_personne integer NOT NULL,
    date_souscription date,
    id_programme integer
);
    DROP TABLE public.client;
       public         heap    postgres    false            ?            1259    18410    client_id_client_seq    SEQUENCE     ?   CREATE SEQUENCE public.client_id_client_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.client_id_client_seq;
       public          postgres    false    220            :           0    0    client_id_client_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.client_id_client_seq OWNED BY public.client.id_client;
          public          postgres    false    219            ?            1259    18285    devis    TABLE       CREATE TABLE public.devis (
    num_devis integer NOT NULL,
    id_client integer NOT NULL,
    datedebut date NOT NULL,
    datefin date NOT NULL,
    immatriculation integer NOT NULL,
    agencedepart integer NOT NULL,
    agencearrivee integer NOT NULL,
    prix money
);
    DROP TABLE public.devis;
       public         heap    postgres    false            ?            1259    18283    devis_num_devis_seq    SEQUENCE     ?   CREATE SEQUENCE public.devis_num_devis_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.devis_num_devis_seq;
       public          postgres    false    212            ;           0    0    devis_num_devis_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.devis_num_devis_seq OWNED BY public.devis.num_devis;
          public          postgres    false    211            ?            1259    18373    employe    TABLE       CREATE TABLE public.employe (
    id_employes integer NOT NULL,
    admin boolean NOT NULL,
    chauffeur boolean NOT NULL,
    hote_accueil boolean NOT NULL,
    login character varying NOT NULL,
    mdp character varying NOT NULL,
    id_personne integer NOT NULL
);
    DROP TABLE public.employe;
       public         heap    postgres    false            ?            1259    18371    employe_id_employes_seq    SEQUENCE     ?   CREATE SEQUENCE public.employe_id_employes_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.employe_id_employes_seq;
       public          postgres    false    216            <           0    0    employe_id_employes_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.employe_id_employes_seq OWNED BY public.employe.id_employes;
          public          postgres    false    215            ?            1259    18313    facture    TABLE     ?   CREATE TABLE public.facture (
    idfacture integer NOT NULL,
    num_devis integer NOT NULL,
    date_rendu date NOT NULL,
    carburantconsomme numeric NOT NULL,
    meme_etat boolean NOT NULL
);
    DROP TABLE public.facture;
       public         heap    postgres    false            ?            1259    18311    facture_idfacture_seq    SEQUENCE     ?   CREATE SEQUENCE public.facture_idfacture_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.facture_idfacture_seq;
       public          postgres    false    214            =           0    0    facture_idfacture_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.facture_idfacture_seq OWNED BY public.facture.idfacture;
          public          postgres    false    213            ?            1259    18212    personne    TABLE       CREATE TABLE public.personne (
    id_personne integer NOT NULL,
    nom character varying NOT NULL,
    prenom character varying NOT NULL,
    mail character varying NOT NULL,
    id_adresse integer NOT NULL,
    numtelephone character varying NOT NULL
);
    DROP TABLE public.personne;
       public         heap    postgres    false            ?            1259    18210    personne_id_personne_seq    SEQUENCE     ?   CREATE SEQUENCE public.personne_id_personne_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.personne_id_personne_seq;
       public          postgres    false    204            >           0    0    personne_id_personne_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.personne_id_personne_seq OWNED BY public.personne.id_personne;
          public          postgres    false    203            ?            1259    18452    programme_fidelite    TABLE     
  CREATE TABLE public.programme_fidelite (
    id_programme integer NOT NULL,
    duree integer NOT NULL,
    description character varying NOT NULL,
    prix money NOT NULL,
    taux_reduction numeric(15,2) NOT NULL,
    typedeprogramme character varying NOT NULL
);
 &   DROP TABLE public.programme_fidelite;
       public         heap    postgres    false            ?            1259    18450 #   programme_fidelite_id_programme_seq    SEQUENCE     ?   CREATE SEQUENCE public.programme_fidelite_id_programme_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public.programme_fidelite_id_programme_seq;
       public          postgres    false    222            ?           0    0 #   programme_fidelite_id_programme_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public.programme_fidelite_id_programme_seq OWNED BY public.programme_fidelite.id_programme;
          public          postgres    false    221            ?            1259    18267    vehicule    TABLE     :  CREATE TABLE public.vehicule (
    immatriculation integer NOT NULL,
    marque character varying NOT NULL,
    modele character varying NOT NULL,
    km numeric NOT NULL,
    type_auto boolean NOT NULL,
    climatisation boolean NOT NULL,
    id_catvehicule integer NOT NULL,
    id_carburant integer NOT NULL
);
    DROP TABLE public.vehicule;
       public         heap    postgres    false            ?            1259    18265    vehicule_immatriculation_seq    SEQUENCE     ?   CREATE SEQUENCE public.vehicule_immatriculation_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.vehicule_immatriculation_seq;
       public          postgres    false    210            @           0    0    vehicule_immatriculation_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.vehicule_immatriculation_seq OWNED BY public.vehicule.immatriculation;
          public          postgres    false    209            h           2604    18207    adresse id_adresse    DEFAULT     x   ALTER TABLE ONLY public.adresse ALTER COLUMN id_adresse SET DEFAULT nextval('public.adresse_id_adresse_seq'::regclass);
 A   ALTER TABLE public.adresse ALTER COLUMN id_adresse DROP DEFAULT;
       public          postgres    false    201    202    202            k           2604    18244    agence id_agence    DEFAULT     t   ALTER TABLE ONLY public.agence ALTER COLUMN id_agence SET DEFAULT nextval('public.agence_id_agence_seq'::regclass);
 ?   ALTER TABLE public.agence ALTER COLUMN id_agence DROP DEFAULT;
       public          postgres    false    207    208    208            p           2604    18399     categorie_carburant id_carburant    DEFAULT     ?   ALTER TABLE ONLY public.categorie_carburant ALTER COLUMN id_carburant SET DEFAULT nextval('public.categorie_carburant_id_carburant_seq'::regclass);
 O   ALTER TABLE public.categorie_carburant ALTER COLUMN id_carburant DROP DEFAULT;
       public          postgres    false    217    218    218            j           2604    18228 !   categorie_vehicule id_catvehicule    DEFAULT     ?   ALTER TABLE ONLY public.categorie_vehicule ALTER COLUMN id_catvehicule SET DEFAULT nextval('public.categorie_vehicule_id_catvehicule_seq'::regclass);
 P   ALTER TABLE public.categorie_vehicule ALTER COLUMN id_catvehicule DROP DEFAULT;
       public          postgres    false    206    205    206            q           2604    18415    client id_client    DEFAULT     t   ALTER TABLE ONLY public.client ALTER COLUMN id_client SET DEFAULT nextval('public.client_id_client_seq'::regclass);
 ?   ALTER TABLE public.client ALTER COLUMN id_client DROP DEFAULT;
       public          postgres    false    219    220    220            m           2604    18288    devis num_devis    DEFAULT     r   ALTER TABLE ONLY public.devis ALTER COLUMN num_devis SET DEFAULT nextval('public.devis_num_devis_seq'::regclass);
 >   ALTER TABLE public.devis ALTER COLUMN num_devis DROP DEFAULT;
       public          postgres    false    211    212    212            o           2604    18376    employe id_employes    DEFAULT     z   ALTER TABLE ONLY public.employe ALTER COLUMN id_employes SET DEFAULT nextval('public.employe_id_employes_seq'::regclass);
 B   ALTER TABLE public.employe ALTER COLUMN id_employes DROP DEFAULT;
       public          postgres    false    215    216    216            n           2604    18316    facture idfacture    DEFAULT     v   ALTER TABLE ONLY public.facture ALTER COLUMN idfacture SET DEFAULT nextval('public.facture_idfacture_seq'::regclass);
 @   ALTER TABLE public.facture ALTER COLUMN idfacture DROP DEFAULT;
       public          postgres    false    214    213    214            i           2604    18215    personne id_personne    DEFAULT     |   ALTER TABLE ONLY public.personne ALTER COLUMN id_personne SET DEFAULT nextval('public.personne_id_personne_seq'::regclass);
 C   ALTER TABLE public.personne ALTER COLUMN id_personne DROP DEFAULT;
       public          postgres    false    203    204    204            r           2604    18455    programme_fidelite id_programme    DEFAULT     ?   ALTER TABLE ONLY public.programme_fidelite ALTER COLUMN id_programme SET DEFAULT nextval('public.programme_fidelite_id_programme_seq'::regclass);
 N   ALTER TABLE public.programme_fidelite ALTER COLUMN id_programme DROP DEFAULT;
       public          postgres    false    221    222    222            l           2604    18270    vehicule immatriculation    DEFAULT     ?   ALTER TABLE ONLY public.vehicule ALTER COLUMN immatriculation SET DEFAULT nextval('public.vehicule_immatriculation_seq'::regclass);
 G   ALTER TABLE public.vehicule ALTER COLUMN immatriculation DROP DEFAULT;
       public          postgres    false    210    209    210                      0    18204    adresse 
   TABLE DATA           ?   COPY public.adresse (id_adresse, rue, code_postal) FROM stdin;
    public          postgres    false    202   ?v                 0    18241    agence 
   TABLE DATA           l   COPY public.agence (id_agence, nom, numtelephone, id_adresse, gps_lat, gps_long, nbmaxvehicule) FROM stdin;
    public          postgres    false    208   Gw       )          0    18396    categorie_carburant 
   TABLE DATA           G   COPY public.categorie_carburant (id_carburant, type, prix) FROM stdin;
    public          postgres    false    218   dw                 0    18225    categorie_vehicule 
   TABLE DATA           I   COPY public.categorie_vehicule (id_catvehicule, type, tarif) FROM stdin;
    public          postgres    false    206   ?w       +          0    18412    client 
   TABLE DATA           Y   COPY public.client (id_client, id_personne, date_souscription, id_programme) FROM stdin;
    public          postgres    false    220   ?w       #          0    18285    devis 
   TABLE DATA           }   COPY public.devis (num_devis, id_client, datedebut, datefin, immatriculation, agencedepart, agencearrivee, prix) FROM stdin;
    public          postgres    false    212   ?w       '          0    18373    employe 
   TABLE DATA           g   COPY public.employe (id_employes, admin, chauffeur, hote_accueil, login, mdp, id_personne) FROM stdin;
    public          postgres    false    216   x       %          0    18313    facture 
   TABLE DATA           a   COPY public.facture (idfacture, num_devis, date_rendu, carburantconsomme, meme_etat) FROM stdin;
    public          postgres    false    214   ?x                 0    18212    personne 
   TABLE DATA           \   COPY public.personne (id_personne, nom, prenom, mail, id_adresse, numtelephone) FROM stdin;
    public          postgres    false    204   ?x       -          0    18452    programme_fidelite 
   TABLE DATA           u   COPY public.programme_fidelite (id_programme, duree, description, prix, taux_reduction, typedeprogramme) FROM stdin;
    public          postgres    false    222   ?y       !          0    18267    vehicule 
   TABLE DATA              COPY public.vehicule (immatriculation, marque, modele, km, type_auto, climatisation, id_catvehicule, id_carburant) FROM stdin;
    public          postgres    false    210   z       A           0    0    adresse_id_adresse_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.adresse_id_adresse_seq', 25, true);
          public          postgres    false    201            B           0    0    agence_id_agence_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.agence_id_agence_seq', 1, false);
          public          postgres    false    207            C           0    0 $   categorie_carburant_id_carburant_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public.categorie_carburant_id_carburant_seq', 1, false);
          public          postgres    false    217            D           0    0 %   categorie_vehicule_id_catvehicule_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public.categorie_vehicule_id_catvehicule_seq', 3, true);
          public          postgres    false    205            E           0    0    client_id_client_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.client_id_client_seq', 9, true);
          public          postgres    false    219            F           0    0    devis_num_devis_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.devis_num_devis_seq', 1, false);
          public          postgres    false    211            G           0    0    employe_id_employes_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.employe_id_employes_seq', 1, true);
          public          postgres    false    215            H           0    0    facture_idfacture_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.facture_idfacture_seq', 1, false);
          public          postgres    false    213            I           0    0    personne_id_personne_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.personne_id_personne_seq', 25, true);
          public          postgres    false    203            J           0    0 #   programme_fidelite_id_programme_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.programme_fidelite_id_programme_seq', 2, true);
          public          postgres    false    221            K           0    0    vehicule_immatriculation_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.vehicule_immatriculation_seq', 1, false);
          public          postgres    false    209            t           2606    18209    adresse adresse_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.adresse
    ADD CONSTRAINT adresse_pkey PRIMARY KEY (id_adresse);
 >   ALTER TABLE ONLY public.adresse DROP CONSTRAINT adresse_pkey;
       public            postgres    false    202            z           2606    18246    agence agence_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.agence
    ADD CONSTRAINT agence_pkey PRIMARY KEY (id_agence);
 <   ALTER TABLE ONLY public.agence DROP CONSTRAINT agence_pkey;
       public            postgres    false    208            ?           2606    18404 ,   categorie_carburant categorie_carburant_pkey 
   CONSTRAINT     t   ALTER TABLE ONLY public.categorie_carburant
    ADD CONSTRAINT categorie_carburant_pkey PRIMARY KEY (id_carburant);
 V   ALTER TABLE ONLY public.categorie_carburant DROP CONSTRAINT categorie_carburant_pkey;
       public            postgres    false    218            x           2606    18230 *   categorie_vehicule categorie_vehicule_pkey 
   CONSTRAINT     t   ALTER TABLE ONLY public.categorie_vehicule
    ADD CONSTRAINT categorie_vehicule_pkey PRIMARY KEY (id_catvehicule);
 T   ALTER TABLE ONLY public.categorie_vehicule DROP CONSTRAINT categorie_vehicule_pkey;
       public            postgres    false    206            ?           2606    18417    client client_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id_client);
 <   ALTER TABLE ONLY public.client DROP CONSTRAINT client_pkey;
       public            postgres    false    220            ~           2606    18290    devis devis_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.devis
    ADD CONSTRAINT devis_pkey PRIMARY KEY (num_devis);
 :   ALTER TABLE ONLY public.devis DROP CONSTRAINT devis_pkey;
       public            postgres    false    212            ?           2606    18378    employe employe_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.employe
    ADD CONSTRAINT employe_pkey PRIMARY KEY (id_employes);
 >   ALTER TABLE ONLY public.employe DROP CONSTRAINT employe_pkey;
       public            postgres    false    216            ?           2606    18318    facture facture_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.facture
    ADD CONSTRAINT facture_pkey PRIMARY KEY (idfacture);
 >   ALTER TABLE ONLY public.facture DROP CONSTRAINT facture_pkey;
       public            postgres    false    214            v           2606    18217    personne personne_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.personne
    ADD CONSTRAINT personne_pkey PRIMARY KEY (id_personne);
 @   ALTER TABLE ONLY public.personne DROP CONSTRAINT personne_pkey;
       public            postgres    false    204            ?           2606    18460 *   programme_fidelite programme_fidelite_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.programme_fidelite
    ADD CONSTRAINT programme_fidelite_pkey PRIMARY KEY (id_programme);
 T   ALTER TABLE ONLY public.programme_fidelite DROP CONSTRAINT programme_fidelite_pkey;
       public            postgres    false    222            |           2606    18272    vehicule vehicule_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.vehicule
    ADD CONSTRAINT vehicule_pkey PRIMARY KEY (immatriculation);
 @   ALTER TABLE ONLY public.vehicule DROP CONSTRAINT vehicule_pkey;
       public            postgres    false    210            ?           2606    18247    agence agence_id_adresse_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.agence
    ADD CONSTRAINT agence_id_adresse_fkey FOREIGN KEY (id_adresse) REFERENCES public.adresse(id_adresse);
 G   ALTER TABLE ONLY public.agence DROP CONSTRAINT agence_id_adresse_fkey;
       public          postgres    false    2932    202    208            ?           2606    18418    client client_id_personne_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_id_personne_fkey FOREIGN KEY (id_personne) REFERENCES public.personne(id_personne);
 H   ALTER TABLE ONLY public.client DROP CONSTRAINT client_id_personne_fkey;
       public          postgres    false    2934    204    220            ?           2606    18296    devis devis_agencearrivee_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.devis
    ADD CONSTRAINT devis_agencearrivee_fkey FOREIGN KEY (agencearrivee) REFERENCES public.agence(id_agence);
 H   ALTER TABLE ONLY public.devis DROP CONSTRAINT devis_agencearrivee_fkey;
       public          postgres    false    208    212    2938            ?           2606    18291    devis devis_agencedepart_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.devis
    ADD CONSTRAINT devis_agencedepart_fkey FOREIGN KEY (agencedepart) REFERENCES public.agence(id_agence);
 G   ALTER TABLE ONLY public.devis DROP CONSTRAINT devis_agencedepart_fkey;
       public          postgres    false    208    2938    212            ?           2606    18306     devis devis_immatriculation_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.devis
    ADD CONSTRAINT devis_immatriculation_fkey FOREIGN KEY (immatriculation) REFERENCES public.vehicule(immatriculation);
 J   ALTER TABLE ONLY public.devis DROP CONSTRAINT devis_immatriculation_fkey;
       public          postgres    false    212    2940    210            ?           2606    18319    facture facture_num_devis_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.facture
    ADD CONSTRAINT facture_num_devis_fkey FOREIGN KEY (num_devis) REFERENCES public.devis(num_devis);
 H   ALTER TABLE ONLY public.facture DROP CONSTRAINT facture_num_devis_fkey;
       public          postgres    false    2942    212    214            ?           2606    18355 "   agence fk1push393fv6p9g6iq4vq04jlh    FK CONSTRAINT     ?   ALTER TABLE ONLY public.agence
    ADD CONSTRAINT fk1push393fv6p9g6iq4vq04jlh FOREIGN KEY (id_adresse) REFERENCES public.adresse(id_adresse);
 L   ALTER TABLE ONLY public.agence DROP CONSTRAINT fk1push393fv6p9g6iq4vq04jlh;
       public          postgres    false    208    2932    202            ?           2606    18461 "   client fkawsbfrkhwsmfp32uxyf45edlt    FK CONSTRAINT     ?   ALTER TABLE ONLY public.client
    ADD CONSTRAINT fkawsbfrkhwsmfp32uxyf45edlt FOREIGN KEY (id_personne) REFERENCES public.personne(id_personne);
 L   ALTER TABLE ONLY public.client DROP CONSTRAINT fkawsbfrkhwsmfp32uxyf45edlt;
       public          postgres    false    2934    220    204            ?           2606    18405 $   vehicule fkdp4aq28lejj4fgowroldabcj2    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vehicule
    ADD CONSTRAINT fkdp4aq28lejj4fgowroldabcj2 FOREIGN KEY (id_carburant) REFERENCES public.categorie_carburant(id_carburant);
 N   ALTER TABLE ONLY public.vehicule DROP CONSTRAINT fkdp4aq28lejj4fgowroldabcj2;
       public          postgres    false    210    2948    218            ?           2606    18379 #   employe fklka4uauepp0chf88uafyhvewj    FK CONSTRAINT     ?   ALTER TABLE ONLY public.employe
    ADD CONSTRAINT fklka4uauepp0chf88uafyhvewj FOREIGN KEY (id_personne) REFERENCES public.personne(id_personne);
 M   ALTER TABLE ONLY public.employe DROP CONSTRAINT fklka4uauepp0chf88uafyhvewj;
       public          postgres    false    216    2934    204            ?           2606    18365 $   personne fko9n1y8lj7dmfdsx1fa8q7osdx    FK CONSTRAINT     ?   ALTER TABLE ONLY public.personne
    ADD CONSTRAINT fko9n1y8lj7dmfdsx1fa8q7osdx FOREIGN KEY (id_adresse) REFERENCES public.adresse(id_adresse);
 N   ALTER TABLE ONLY public.personne DROP CONSTRAINT fko9n1y8lj7dmfdsx1fa8q7osdx;
       public          postgres    false    204    202    2932            ?           2606    18218 !   personne personne_id_adresse_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.personne
    ADD CONSTRAINT personne_id_adresse_fkey FOREIGN KEY (id_adresse) REFERENCES public.adresse(id_adresse);
 K   ALTER TABLE ONLY public.personne DROP CONSTRAINT personne_id_adresse_fkey;
       public          postgres    false    204    2932    202            ?           2606    18273 %   vehicule vehicule_id_catvehicule_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vehicule
    ADD CONSTRAINT vehicule_id_catvehicule_fkey FOREIGN KEY (id_catvehicule) REFERENCES public.categorie_vehicule(id_catvehicule);
 O   ALTER TABLE ONLY public.vehicule DROP CONSTRAINT vehicule_id_catvehicule_fkey;
       public          postgres    false    2936    206    210               ?   x?m?1?0??W?D?6`?C
*?4?8?#?%Q?h?4+?h???i??kKOiK????'S?m??^% ?iE\↸%?? ?³?Hp%8܉FD????H???xĢ????ܑr???I?%T??????8?~U?v?f?            x?????? ? ?      )      x?????? ? ?         <   x?3??)?H?45?10PxԴ?ˈ?9?/-????.f?y?39?/?7??4??.???? ???      +       x???42?4202?50?52????????? 3?      #      x?????? ? ?      '   k   x?3?,?L?Ĕ??<Τ??ʂ+Cc+3+C3?<++?JCc??T?R??̠??0??7?"?`??p?0#? ????Lא?R_?R??HKGS??`?`Nc?=... ?Qk      %      x?????? ? ?         ?   x??QAN?0<?ce?mBn??!?8pY??b[?Ҫ<?w?1?P?s?????h5? ?R????l{??@D???3???Ox:@??ӡ?/?6?T?1??ό??G̃??]Y1̥??y??.?9$???M???UMu???+C?:Q?]A??????0\????f?eSZ2?1?%jZ????4??B???սF	??s/rr??Y?%??Q???????/.???U??X?ﺰy??5?|????      -   W   x?3?4??J-?K?45?10PxԴ??30?:?2?4?$3?O!??ˈӐ3?(?-??(???ih?[KA~i?BNj?BAQ~1W? 
4!?      !      x?????? ? ?     